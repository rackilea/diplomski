CompletionService<String> completionService = new ExecutorCompletionService<String>(executor);

// place all the work in a function (an Anonymous Runnable in this case)
// completionService.submit(() ->{work});
// as soon as the work is submitted it is handled by another Thread

completionService.submit(() ->{
    logger.info("Submitting all tasks");
    for (Callable<String> task : tasks)
    completionService.submit(task);
    logger.info("Tasks submitted. Now checking the status.");
    int counter = tasks.size();
    for(int i = counter; counter >=1; counter--)  // Replaced the while loop
    {
        final Future<String> future = completionService.take();
        String itemValue;
        try
        {
            itemValue = future.get();
            if (!itemValue.equals("Bulk"))
                logger.info("Backup completed for " + itemValue);
        }
        catch (InterruptedException | ExecutionException e)
        {
            String message = e.getCause().getMessage();
            String objName = "Bulk";
            if (message.contains("(") && message.contains(")"))
                objName = message.substring(message.indexOf("(") + 1, message.indexOf(")"));
            logger.error("Failed retrieving the task status for " + objName, e);
        }
    }
});

// After submitting the work to another Thread
// Wait in your Main Thread, and enforce termination if needed
shutdownAndAwaitTermination(executor);