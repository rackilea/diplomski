public class MyThread extends Thread {
    private final String task, taskId;
    private final int actionTime; //Dummy uptime to simulate.
    private final MyTaskQueue q;

    public MyThread(MyTaskQueue q, String task, String taskId, int actionTime) {
        this.q = q;
        this.task = task;
        this.taskId = taskId;
        this.actionTime = actionTime;
    }

    @Override
    public void run() {
        q.enque(task, taskId); //Wait for permission to run...
        System.out.println("Task {\"" + task + "\", \"" + taskId + "\"} is currently running...");

        //Now lets actually execute the task of the Thread:
        try { Thread.sleep(actionTime); } catch (InterruptedException ie) { /*Handle the exception.*/ }

        q.deque(task, taskId); //Declare Thread ended.
    }
}