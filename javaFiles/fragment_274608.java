public class ThreadMain{
    private static List<ConsumerThread> consumers = new ArrayList<ConsumerThread>();

    public static void main(String[] args) {
        int NUM_THREAD = 15;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);

        CountDownLatch latch = new CountDownLatch(NUM_THREAD);
        ConsumerThread buffer = new ConsumerThread(latch);
        for (int i = 0; i < NUM_THREAD; i++){
            consumers.add(buffer);
            executor.execute(buffer);
            latch.countDown();
            buffer = new ConsumerThread(latch);
        }

        for (int i = 0; i < 100; i++){
            System.out.println("Status for Thread 0: " + getStatusId(0));
            System.out.println("Status for Thread 14: " + getStatusId(14));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getStatusId(int index){
        return consumers.get(index).getStatus();
    }
}