public class LocalAWSS3ClientManagerImpl implements AWSS3ClientManager {
    private static Logger logger = LoggerFactory.getLogger(LocalAWSS3ClientManagerImpl.class);
    private PriorityCodeSourcesRoutesProperties priorityCodeSourcesRoutesProperties;
    private SimpleRegistry registry = new SimpleRegistry();
    private CamelContext camelContext;

public LocalAWSS3ClientManagerImpl(PriorityCodeSourcesRoutesProperties priorityCodeSourcesRoutesProperties) {
    this.priorityCodeSourcesRoutesProperties = priorityCodeSourcesRoutesProperties;
    registry.put("amazonS3Client", getS3Client());
    camelContext = new DefaultCamelContext(registry);
    logger.info("Creating an AWS S3 manager for a local instance (you should not see this on AWS EC2s).");
}

private AmazonS3 getS3Client() {
    try {
        String awsBucketAccessKey = priorityCodeSourcesRoutesProperties.getAwsBucketAccessKey();
        String awsBucketSecretKey = priorityCodeSourcesRoutesProperties.getAwsBucketSecretKey();
        AWSCredentials awsCredentials = new BasicAWSCredentials(awsBucketAccessKey, awsBucketSecretKey);
        return AmazonS3ClientBuilder.standard().withCredentials(
                new AWSStaticCredentialsProvider(awsCredentials)).build();
    } catch (RuntimeException ex) {
        logger.error("Could not create AWS S3 client with the given credentials from the local config.");
    }
    return null;
}

public Endpoint getIncomingAWSEndpoint(final String incomingAWSBucket, final String region,
        final String fileNameToSaveAndDownload) {
    return camelContext.getEndpoint(
            "aws-s3://" + incomingAWSBucket + "?" + "amazonS3Client=#amazonS3Client"
            + "&region=" + region + "&deleteAfterRead=false" + "&prefix=" + fileNameToSaveAndDownload);
}

public Endpoint getOutgoingLocalEndpoint(final String outgoingEndpointDirectory,
        final String fileNameToSaveAndDownload) {
    return camelContext.getEndpoint(
            "file://" + outgoingEndpointDirectory + "?" + "fileName="
            + fileNameToSaveAndDownload + "&readLock=markerFile");
}
}