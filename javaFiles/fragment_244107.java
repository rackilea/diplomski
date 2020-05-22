import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Scheduler {

    public static void main(String[] args) throws InterruptedException {
        final ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);

        System.out.println("- [" + LocalTime.now() + "] run parent-task...");

        int noOfTask=3;
        CountDownLatch countDownLatch = new CountDownLatch(noOfTask);

        TaskComplete taskComplete=new TaskCompleteImpl(noOfTask,countDownLatch);

        // create 3 tasks: each task needs 7 seconds.
        List<Runnable> tasks = createTasks("child", noOfTask, 7,countDownLatch,taskComplete);

        List<ScheduledFuture<?>> futures = new ArrayList<>();
        tasks.forEach(t ->
        {
            ScheduledFuture<?> future = ses.scheduleWithFixedDelay(t, 0, 2, TimeUnit.SECONDS);
            futures.add(future);
        });
        // this does not work..





    }

    interface TaskComplete{
        void tasksCompleted();
    }

    static class TaskCompleteImpl implements TaskComplete {

        int totalTask=0;
        int index=0;
        CountDownLatch countDownLatch;
        public TaskCompleteImpl(int totalTask){

        }

        public TaskCompleteImpl(int noOfTask, CountDownLatch countDownLatch) {
            this.totalTask=noOfTask;
            this.countDownLatch=countDownLatch;
        }

        @Override
        public synchronized void tasksCompleted() {
            index=index+1;
            if(index==totalTask){
                System.out.println("schedule cycle completed");
                index=0;
                countDownLatch=new CountDownLatch(totalTask);
            }

        }
    }


    static List<Runnable> createTasks(String group, int numbersOfTasks, long taskDuration, CountDownLatch countDownLatch, TaskComplete taskComplete) {
        List tasks = new ArrayList<Runnable>();
        for (int i = 0; i < numbersOfTasks; i++) {
            int taskNr = i;
            Runnable task = () ->
            {
                System.out.println("- [" + LocalTime.now() + "] Running " + group + "-task" + taskNr + "...[needs "
                        + taskDuration + " seconds]");
                try {
                    TimeUnit.SECONDS.sleep(taskDuration);
                    countDownLatch.countDown();
                    countDownLatch.await();
                    taskComplete.tasksCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            };
            tasks.add(task);
        }
        return tasks;
    }

}