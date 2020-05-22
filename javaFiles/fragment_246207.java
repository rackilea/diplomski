public class Solution {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1000);
    //a map of taskQueues. We queue all tasks of same ID.
    private static final ConcurrentHashMap<Long, BlockingDeque<MyTask>> mapOfTasks = new ConcurrentHashMap<>(1000);

    public boolean submitWithChecks(Runnable task, long ID, long interval) {


        final BlockingDeque<MyTask> queue;
        if(mapOfTasks.containsKey(ID)) queue = mapOfTasks.get(ID);
        else queue = new LinkedBlockingDeque<>(1000);

        //At this point we have a valid queue object

        try {
            //insert the task into the queue
            queue.putLast(new MyTask(task, ID, interval));
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }

        //If the queue was already present it will get Updated my previous queue.putLast operation
        //If the queue was not present, we put it in the map and start a new queueEater thread.
        if(!mapOfTasks.containsKey(ID)) {
            mapOfTasks.put(ID, queue);
            scheduler.submit(new QueueEater(ID)); //start a new task execution queue
        }
        return true;
    }

    private class QueueEater implements Runnable {

        //This queueEater will consume the queue with this taskID
        private final Long ID;

        private QueueEater(Long id) {
            ID = id;
        }

        @Override
        public void run() {

            //QueueEater will poll the mapOfTasks for the queue Object with its associated ID
            while (mapOfTasks.containsKey(ID)) {

                final BlockingDeque<MyTask> tasks = mapOfTasks.get(ID);
                if(tasks.size() == 0) {
                    mapOfTasks.remove(ID);
                    return; //if task queue empty kill this thread;
                }

                final MyTask myTask;
                try {
                    myTask = tasks.takeFirst();
                    //schedule the task with given interval
                    final Future future = scheduler.schedule(myTask.getTask(), myTask.getInterval(), TimeUnit.SECONDS);
                    future.get(); //wait till this task gets executed before scheduling new task
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private class MyTask {

        private final Runnable task;
        private final long ID;
        private final long interval;

        public long getInterval() {
            return interval;
        }

        public long getID() {
            return ID;
        }

        public Runnable getTask() {
            return task;
        }

        private MyTask(Runnable task, long id, long interval) {
            this.task = task;
            ID = id;
            this.interval = interval;
        }
    }
}