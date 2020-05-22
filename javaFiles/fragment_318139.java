@ServiceActivator
public ChunkResponse handleChunk(ChunkRequest<S> chunkRequest) throws Exception {

    if (logger.isDebugEnabled()) {
        logger.debug("Handling chunk: " + chunkRequest);
    }

    StepContribution stepContribution = chunkRequest.getStepContribution();

    Throwable failure = process(chunkRequest, stepContribution);
    if (failure != null) {
        logger.debug("Failed chunk", failure);
        return new ChunkResponse(false, chunkRequest.getSequence(), chunkRequest.getJobId(), stepContribution, failure.getClass().getName()
                + ": " + failure.getMessage());
    }

    if (logger.isDebugEnabled()) {
        logger.debug("Completed chunk handling with " + stepContribution);
    }
    return new ChunkResponse(true, chunkRequest.getSequence(), chunkRequest.getJobId(), stepContribution);

}