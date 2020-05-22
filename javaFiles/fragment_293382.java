public class ArrayWorker implements Runnable {
    private static final List<ArrayWorker> threadList = new LinkedList<>();
    private static final Random rnd = new Random(System.currentTimeMillis());

    private final int[] array;
    private final int index;


    public ArrayWorker(final int[] array, final int index) {
        if (index > array.length - 1) {
            throw new IndexOutOfBoundsException(String.format("%d", index - array.length));
        }

        this.array = array;
        this.index = index;
        System.out.println(this + " has been created");
    }


    @Override
    public void run() {
        System.out.println(this + " run()");
        this.array[this.index] = rnd.nextInt(100);

        if (index < array.length - 2) {
            final ArrayWorker worker = new ArrayWorker(array, index + 1);

            System.out.println(this + " has created: " + worker);
            new Thread(worker).start();

            threadList.add(this);
            try {
                synchronized (this) {
                    System.out.println(this + " is now waiting");
                    this.wait();
                    System.out.println(this + " got notified");
                }
            } catch (InterruptedException ex) {
                System.out.println("Error while waiting for termination");
                threadList.remove(this);
            }
        } else {
            threadList.forEach(worker -> {
                synchronized(worker) {
                    System.out.println(this + " notifying: " + worker);
                    worker.notify();
                }
            });
        }
    }

    @Override
    public String toString() {
        return "WorkerThread[" + index + "]";
    }  
}