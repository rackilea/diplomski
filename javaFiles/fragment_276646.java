KinesisClientLibConfiguration streamConfig = new KinesisClientLibConfiguration(
 "consumerName", "streamName", getAuthProfileCredentials(), "consumerName-" + "consumerInstanceId")
            .withKinesisClientConfig(getHttpConfiguration())
            .withInitialPositionInStream(InitialPositionInStream.TRIM_HORIZON); // "TRIM_HORIZON" = from the tip of the stream

Worker consumerWorker = new Worker.Builder()
            .recordProcessorFactory(new DavidsEventProcessorFactory())
            .config(streamConfig)
            .dynamoDBClient(new DynamoDB(new AmazonDynamoDBClient(getAuthProfileCredentials(), getHttpConfiguration())))
            .build();


public class DavidsEventProcessorFactory implements IRecordProcessorFactory {

    private Logger logger = LogManager.getLogger(DavidsEventProcessorFactory.class);

    @Override
    public IRecordProcessor createProcessor() {
        logger.info("Creating an EventProcessor.");
        return new DavidsEventPartitionProcessor();
    }
}

class DavidsEventPartitionProcessor implements IRecordProcessor {

    private Logger logger = LogManager.getLogger(DavidsEventPartitionProcessor.class);

    //TODO add consumername ?

    private String partitionId;

    private ShutdownReason RE_PARTITIONING = ShutdownReason.TERMINATE;

    public KinesisEventPartitionProcessor() {
    }

    @Override
    public void initialize(InitializationInput initializationInput) {
        this.partitionId = initializationInput.getShardId();
        logger.info("Initialised partition {} for streaming.", partitionId);
    }

    @Override
    public void processRecords(ProcessRecordsInput recordsInput) {
        recordsInput.getRecords().forEach(nativeEvent -> {
            String eventPayload = new String(nativeEvent.getData().array());
            logger.info("Processing an event {} : {}" , nativeEvent.getSequenceNumber(), eventPayload);

            //update offset after configured amount of retries
            try {
                recordsInput.getCheckpointer().checkpoint();
                logger.debug("Persisted the consumer offset to {} for partition {}",
                        nativeEvent.getSequenceNumber(), partitionId);
            } catch (InvalidStateException e) {
                logger.error("Cannot update consumer offset to the DynamoDB table.", e);
                e.printStackTrace();
            } catch (ShutdownException e) {
                logger.error("Consumer Shutting down", e);
                e.printStackTrace();
            }
        });
    }

    @Override
    public void shutdown(ShutdownInput shutdownReason) {
        logger.debug("Shutting down event processor for {}", partitionId);

        if(shutdownReason.getShutdownReason() == RE_PARTITIONING) {
            try {
                shutdownReason.getCheckpointer().checkpoint();
            } catch (InvalidStateException e) {
                logger.error("Cannot update consumer offset to the DynamoDB table.", e);
                e.printStackTrace();
            } catch (ShutdownException e) {
                logger.error("Consumer Shutting down", e);
                e.printStackTrace();
            }
        }
    }

}