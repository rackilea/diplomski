class DavidsEventPartitionProcessor implements IRecordProcessor, IShutdownNotificationAware {

   private String partitionId;

   // few implementations

    @Override
    public void shutdownRequested(IRecordProcessorCheckpointer checkpointer) {
        logger.debug("Shutdown requested for {}", partitionId);
    }

}