public class Worker implements Runnable {

    public Worker (SharedTask task) {
        this.task = task;
        ...
    }

    public void run() {
        task.method1();
        task.method2();
    }
}