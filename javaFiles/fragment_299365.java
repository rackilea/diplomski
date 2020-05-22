try {
    ReceiveMessageResult receiveMessageResult = getAmazonSqs().receiveMessage(this.queueAttributes.getReceiveMessageRequest());
    CountDownLatch messageBatchLatch = new CountDownLatch(receiveMessageResult.getMessages().size());
    for (Message message : receiveMessageResult.getMessages()) {
        if (isQueueRunning()) {
            MessageExecutor messageExecutor = new MessageExecutor(this.logicalQueueName, message, this.queueAttributes);
                 getTaskExecutor().execute(new SignalExecutingRunnable(messageBatchLatch, messageExecutor));
        } else {
           messageBatchLatch.countDown();
        }
    }
    try {
         messageBatchLatch.await();
    } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
    }
} catch (Exception e) {