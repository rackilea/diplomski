class Task implements Runnable {
private SemaphoreWithQueues semaphore;
public Task(SemaphoreWithQueues semaphore){
    this.semaphore = semaphore;
}

public void run(){
    for (int i = 0; i <5; i++) {
        semaphore.enter();
        try {
            semaphore.leave();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

}
public class Main {
public static void main(String[] args) {
    SemaphoreWithQueues semaphoreWithQueues = new SemaphoreWithQueues(5);
    Thread th1 = new Thread(new Task(semaphoreWithQueues));
    Thread th2 = new Thread(new Task(semaphoreWithQueues));
    Thread th3 = new Thread(new Task(semaphoreWithQueues));
    th1.start();
    th2.start();
    th3.start();
}

}