public class QueueTriggerJava {
    /**
     * This function will be invoked when a new message is received at the specified path. The message contents are provided as input to this function.
     */
    @FunctionName("QueueTriggerJava")
    public void queueHandler(
        @QueueTrigger(name = "message", queueName = "input-queue-items", connection = "AzureWebJobsStorage") String message,
        @QueueOutput(name = "outMessages", queueName = "outout-queue-items", connection = "AzureWebJobsStorage") OutputBinding<List<String>> outMessages,
        final ExecutionContext context
    ) {
        List<String> allMessages = new LinkedList<String>();
        allMessages.add(message);
        allMessages.add(message);
        outMessages.setValue(allMessages);
        context.getLogger().info("Message count: " + outMessages.getValue().size());
    }
}