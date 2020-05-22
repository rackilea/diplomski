class SemaphoreWithQueues implements Semaphore{
private BlockingQueue<Integer> queue;

public SemaphoreWithQueues(int permits) {
    if(queue == null){
        queue = new ArrayBlockingQueue<>(permits);
    }
}

public void enter() {
    queue.offer(1);
    System.out.println(Thread.currentThread().getName() + " got a permit.");
}

public void leave() throws InterruptedException {
    queue.take();
    System.out.println(Thread.currentThread().getName() + " left the permit.");
}
}