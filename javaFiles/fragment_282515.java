...
MyTask myTask = new MyTask();
Future<String> future = executor.submit(myTask);
...
} catch (InterruptedException | ExecutionException e) {
    StackTraceElement[] stack = myTask.getExecutorThread().getStackTrace();
    for (StackTraceElement element : stack) {
        ...print it...
    }
}