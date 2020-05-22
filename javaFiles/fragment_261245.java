public class SchedulerTest {

    @Test
    public void scheduler() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        TaskCompleteEvent taskCompleteEvent = new TaskCompleteEvent(scheduledExecutorService);
        Runnable task1 = () -> {
            int num = new Random().nextInt(100);
            if (num < 5) {
                taskCompleteEvent.message("task1-"+UUID.randomUUID().toString(), "Num "+num+" was obatined. Breaking all the executions.", true);
            }
        };
        Runnable task2 = () -> {
            int num = new Random().nextInt(100);
            taskCompleteEvent.message("task2-"+UUID.randomUUID().toString(), num < 50, false);
        };
        scheduledExecutorService.scheduleAtFixedRate(task1, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(task2, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Success: "+taskCompleteEvent.getSuccess());
        System.out.println("Errors: "+taskCompleteEvent.getErrors());
        System.out.println("Went well?: "+taskCompleteEvent.getErrors().isEmpty());
    }

    public static class TaskCompleteEvent {

        private final ScheduledExecutorService scheduledExecutorService;
        private final Map<String, Object> errors = new LinkedHashMap<>();
        private final Map<String, Object> success = new LinkedHashMap<>();

        public TaskCompleteEvent(ScheduledExecutorService scheduledExecutorService) {
            this.scheduledExecutorService = scheduledExecutorService;
        }

        public synchronized void message(String id, Object response, boolean error) {
            if (error) {
                errors.put(id, response);
                scheduledExecutorService.shutdown();
            } else {
                success.put(id, response);
            }
        }

        public synchronized Map<String, Object> getErrors() {
            return errors;
        }

        public synchronized Map<String, Object> getSuccess() {
            return success;
        }

    }

}