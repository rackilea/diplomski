final AtomicInteger messagesReceived = new AtomicInteger(0);

// ThreadedListenerAdapter is the class that I'm testing 
// It's not germane to the question other than as a target for a thread pool.
final ThreadedListenerAdapter<Integer> adapter = 
    new ThreadedListenerAdapter<Integer>(listener);
int taskCount = 10;

List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();

for (int whichTask = 0; whichTask < taskCount; whichTask++) {
    FutureTask<Integer> futureTask = 
        new FutureTask<Integer>(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            // Does useful work that affects messagesSent
            return messagesSent;
        }
    });
    taskList.add(futureTask);
}

for (FutureTask<Integer> task : taskList) {
    LocalExecutorService.getExecutorService().submit(task);
}

for (FutureTask<Integer> task : taskList) {
    int result = 0;
    try {
        result = task.get();
    } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
    } catch (ExecutionException ex) {
        throw new RuntimeException("ExecutionException in task " + task, ex);
    }
    assertEquals(maxMessages, result);
}

int messagesSent = taskCount * maxMessages;
assertEquals(messagesSent, messagesReceived.intValue());