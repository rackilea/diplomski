public void shutdown() {
    if (logger.logDebug()) {
        logger.logDebug(LOGTAG, "Queuing shutdown message ...");
    }

    queueMessage(new BaseMessage(true));
}