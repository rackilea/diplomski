class food {

    public int times;
    public int food;
    public boolean canget = false;
    private CountDownLatch completion;

    public food(CountDownLatch completion) {
        this.completion = completion;
    }

    void eat(int times, producer p) {
        this.times = times;
        p.produce(this);
        consumer pe = new consumer(completion);
        pe.consume(this);
    }

    synchronized void add(int n) {
        while (canget) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Something nasty happened");
            }
        }

        this.food = n;
        System.out.println("Produced food '" + n + "'");
        canget = true;
        notify();
    }

    synchronized int get() {
        while (!canget) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Something Nasty happened");
            }
        }
        canget = false;
        notify();
        System.out.println("Eaten food '" + this.food + "'");
        return this.food;
    }

}

class producer implements Runnable {
    int times;
    food f;
    boolean done;
    private CountDownLatch completion;

    public producer(CountDownLatch completion) {
        this.completion = completion;
    }

    void produce(food F) {
        times = F.times;
        f = F;
        Thread t = new Thread(this);
        t.start();
    }


    public void run() {
        while (this.times-- > 0) {
            f.add(times);
        }
        completion.countDown();
    }
}

class consumer implements Runnable {

    int times;
    food f;
    private CountDownLatch completion;

    public consumer(CountDownLatch completion) {
        this.completion = completion;
    }

    void consume(food F) {
        times = F.times;
        f = F;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while (this.times-- > 0) {
            f.get();
        }
        completion.countDown();
    }
}