import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MyTaskQueue {

    private final Map<String, Set<String>> runningTasks;
    private String qualifiedTaskId;

    public MyTaskQueue(String initialQualifiedTaskId) {
        runningTasks = new HashMap<>();
        qualifiedTaskId = initialQualifiedTaskId;
    }

    private synchronized boolean isValid(String taskId) {
        return qualifiedTaskId != null && taskId != null && taskId.equals(qualifiedTaskId); //Do your qualification tests here...
    }

    public synchronized void setQualifiedTaskId(String qualifiedTaskId) {
        this.qualifiedTaskId = qualifiedTaskId;
        notifyAll(); //Now that the qualification test changed, is time to notify every blocked task.
        //This way, all new qualified tasks will also be started. This "notifyAll()" operation is optional.
    }

    public synchronized void enque(String task, String taskId) {
        while (!isValid(taskId)) { //Reentrant lock.
            System.out.println("Blocking unqualified task {\"" + task + "\", \"" + taskId + "\"}...");
            try { wait(); } catch (InterruptedException ie) { /*Handle the exception...*/ }
        }
        runningTasks.putIfAbsent(task, new HashSet<>());
        runningTasks.get(task).add(taskId);
        System.out.println("Starting qualified task {\"" + task + "\", \"" + taskId + "\"}...");
    }

    //Optional method. Might be needed for example if a Thread
    //wants to check if another task is currently running...
    public synchronized boolean isRunning(String task, String taskId) {
        return runningTasks.containsKey(task) && runningTasks.get(task).contains(taskId);
    }

    public synchronized void deque(String task, String taskId) {
        if (isRunning(task, taskId)) { //Reentrant lock.

            //Cleanup:
            runningTasks.get(task).remove(taskId);
            if (runningTasks.get(task).isEmpty())
                runningTasks.remove(task);

            //Notify all blocked tasks:
            notifyAll();
        }
    }

    public static void main(final String[] args) {
        MyTaskQueue q = new MyTaskQueue("qualified");
        Random rand = new Random();
        new MyThread(q, "Task1", "qualified222", 2500 + rand.nextInt(500)).start();
        new MyThread(q, "Task2", "qualified222", 2500 + rand.nextInt(500)).start();
        new MyThread(q, "Task3", "qualified", 2500 + rand.nextInt(500)).start();
        new MyThread(q, "Task4", "qualified", 2500 + rand.nextInt(500)).start();
        new MyThread(q, "Task5", "foreverBlocked", 2500 + rand.nextInt(500)).start();
        try { Thread.sleep(3000); } catch (InterruptedException ie) { /*Handle the exception...*/ }
        synchronized (q) {
            System.out.println("Qualifying tasks of id \"qualified222\"...");
            q.setQualifiedTaskId("qualified222"); //Reentrant lock.
        }
        //Execution of main method never ends, because of the forever blocked task "Task5".
        //The "Task5" still runs while waiting for permission... See MyThread for details...
    }
}