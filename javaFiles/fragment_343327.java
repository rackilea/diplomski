public class Test {
    public static void main(String[] args) throws Exception {
        // The object we want to manage or track with the task.
        TaskObject executedObject = new TaskObject("Foo");

        // Executing the task.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Task(executedObject));
        executor.shutdown();

        // Wait in this thread and change the name of the object.
        Thread.sleep(3000L);
        executedObject.setName("New Name");

        // Wait for the end of the task.
        executor.awaitTermination(15L, TimeUnit.SECONDS);
    }
}