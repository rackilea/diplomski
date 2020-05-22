enum Branch {

    Production(0.007, 0.008),
    Financial(0.009, 0.007),
    Marketing(0.0095, 0.0082);
    // PB/FB/MB
    final String id = name().charAt(0) + "B";
    // Costs.
    final double printCost;
    final double dataCost;

    private Branch(double printCost, double dataCost) {
        this.printCost = printCost;
        this.dataCost = dataCost;
    }

    // One lock for each computer at this branch.
    Lock[] computers = new Lock[3];

    {
        for (int i = 0; i < computers.length; i++) {
            computers[i] = new ReentrantLock();
        }
    }

    public void lock(int computer) {
        computers[computer - 1].lock();
    }

    public void unlock(int computer) {
        computers[computer - 1].unlock();
    }

    AtomicInteger dataProcessed = new AtomicInteger();

    public void data(int amount) {
        dataProcessed.addAndGet(amount);
    }

    AtomicInteger printProcessed = new AtomicInteger();

    public void print(int amount) {
        printProcessed.addAndGet(amount);
    }

    public static Branch lookup(String id) {
        for (Branch b : Branch.values()) {
            if (b.id.equals(id)) {
                return b;
            }
        }
        return null;
    }

    private void printStats() {
        System.out.println("Branch " + name()
                + " processed " + dataProcessed
                + " cost=" + (dataProcessed.get() * dataCost)
                + " printed " + printProcessed
                + " cost=" + (printProcessed.get() * printCost)
        );
    }

}

enum Function {

    Data {

                @Override
                void function(Branch b, int size) {
                    b.data(size);
                }
            },
    Print {
                @Override
                void function(Branch b, int size) {
                    b.print(size);
                }
            };
    // D/P
    final String id = "" + name().charAt(0);

    public static Function lookup(String id) {
        for (Function b : Function.values()) {
            if (b.id.equals(id)) {
                return b;
            }
        }
        return null;
    }

    abstract void function(Branch b, int size);
}

class Router {

    public void job(String branch, int computer, String function, int size) {
        Branch b = Branch.lookup(branch);
        // Grab the lock on that computer at that branch.
        b.lock(computer);
        try {
            Function f = Function.lookup(function);
            f.function(b, size);
        } finally {
            b.unlock(computer);
        }
    }

    private void job(Job j) {
        job(j.branch, j.computer, j.function, j.data);
    }

    private void printStats() {
        // For all branches:
        for (Branch b : Branch.values()) {
            b.printStats();
        }
    }
}
// Just one router.
final Router router = new Router();

class Job implements Runnable {

    String branch;
    int computer;
    String function;
    int data;

    public Job(String branch, int computer, String function, int data) {
        this.branch = branch;
        this.computer = computer;
        this.function = function;
        this.data = data;
    }

    @Override
    public void run() {
        router.job(this);
    }

}

public void test() throws InterruptedException {
    System.out.println("Hello");
    Job[] jobs = {
        new Job("PB", 1, "D", 60000),
        new Job("PB", 3, "P", 100000),
        new Job("PB", 2, "D", 75000),
        new Job("FB", 1, "P", 30000),
        new Job("FB", 2, "D", 150000),
        new Job("FB", 3, "P", 89000),
        new Job("MB", 1, "P", 200000),
        new Job("MB", 2, "D", 140000),
        new Job("MB", 3, "P", 1350000)};
    Thread[] threads = new Thread[jobs.length];
    for (int i = 0; i < threads.length; i++) {
        threads[i] = new Thread(jobs[i]);
        threads[i].start();
    }
    for (int i = 0; i < threads.length; i++) {
        threads[i].join();
    }
    router.printStats();
}