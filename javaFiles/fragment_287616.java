public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> c = new ArrayBlockingQueue<Integer>(1);
        CountDownLatch doneSignal = new CountDownLatch(3);

        Processor c1 = new Processor(c, 2, doneSignal);

        BubbleWitch2 p1 = new BubbleWitch2(c, 1, doneSignal);        
        Spotify p2 = new Spotify(c, 3, doneSignal);
        SystemManagement p3 = new SystemManagement(c,4, doneSignal);
        SecurityUpdate p4 = new SecurityUpdate(c,5, doneSignal);

        p1.setName("BubbleWitch2 ");
        p2.setName("Spotify ");
        p3.setName("System Management ");
        p4.setName("Security Update ");

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(c1);
        exec.submit(p1);
        exec.submit(p2);
        exec.submit(p3);        

        Future<?> securityFuture = exec.submit(p4);

        try {
            while(securityFuture.get()!=null) {

            }           
            exec.shutdown();
            while(exec.awaitTermination(1000, TimeUnit.MILLISECONDS)) {

            }
            exec.shutdownNow();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.exit(0);
    }
}
class Processor extends Thread {
    private BlockingQueue<Integer> cubbyhole;
    private int number;
    private CountDownLatch doneSignal;

    public Processor(BlockingQueue<Integer> c, int number,CountDownLatch doneSignal) {
        cubbyhole = c;
        this.number = number;
        this.doneSignal = doneSignal;
    }
    public void run() {
        int value = 0;
       // for (int i = 0; i < 60; i++) {
        while(true) {
            try {
                value = cubbyhole.take();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
            System.out.println("Processor #"
                    + this.number
                    + " got: " + value);
        }
        //doneSignal.countDown();
    }
}

class Spotify extends Thread {
    private BlockingQueue<Integer> buffer;
    private int number;
    private int bytes;
    private CountDownLatch doneSignal;

    public Spotify(BlockingQueue<Integer> c, int number, CountDownLatch doneSignal) {
        buffer = c;
        this.number = number;
        this.doneSignal = doneSignal;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                buffer.put(i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(getName() + this.number
                    + " put: " + i);           
        }
        System.out.println("*****************************");
        System.out.println("Spotify has finished executing.");
        System.out.println("*****************************");
        doneSignal.countDown();
    }
}

class BubbleWitch2 extends Thread {
    private BlockingQueue<Integer> buffer;
    private int number;
    private int bytes;
    private CountDownLatch doneSignal;

    public BubbleWitch2(BlockingQueue<Integer> c, int number, CountDownLatch doneSignal) {
        buffer = c;
        this.number = number;
        this.doneSignal = doneSignal;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.put(i);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println(getName() + this.number
                    + " put: " + i);

        }
        System.out.println("*****************************");
        System.out.println("BubbleWitch2 has finished executing.");
        System.out.println("*****************************");
        doneSignal.countDown();
    }
}

class SystemManagement extends Thread {
    private BlockingQueue<Integer> buffer;
    private int number, min = 1, max = 15;
    private int loopCount = (int) (Math.random() * ( max - min ));
    private CountDownLatch doneSignal;

    public SystemManagement(BlockingQueue<Integer> c, int number, CountDownLatch doneSignal) {
        buffer = c;
        this.number = number;
        this.doneSignal = doneSignal;
    }

    public void run() {
        for (int i = 0; i < loopCount; i++) {
            try {
                buffer.put(i);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println(getName() + this.number
                    + " put: " + i);

        }
        System.out.println("*****************************");
        System.out.println("System Management has finished executing.");
        System.out.println("*****************************");
        doneSignal.countDown();
    }
}

class SecurityUpdate extends Thread {
    private BlockingQueue<Integer> buffer;
    private int number;
    private int bytes = 150;
    private int process = 0;
    private CountDownLatch doneSignal;

    public SecurityUpdate (BlockingQueue<Integer> c, int number, CountDownLatch doneSignal) {
        buffer = c;
        this.number = number;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            doneSignal.await();         
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            try {
                buffer.put(i);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.out.println(getName() + this.number
                    + " put: " + i);

        }
        System.out.println("*****************************");
        System.out.println("Security Update has finished executing.");
        System.out.println("*****************************");
    }
}