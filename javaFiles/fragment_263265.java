public class OnesRun implements Runnable {

    private static final AtomicInteger ones = new AtomicInteger();

    private final int passendNumber;

    public OnesRun(int passendNumber) {
        this.passendNumber = passendNumber;
    }

    public void run() {
        if (passendNumber == 1)
            OnesRun.ones.incrementAndGet();
    }

    public static void setOnes(int newValue) {
        ones.set(newValue);
    }

    public static int getOnes() {
        return ones.get()
    }
}

...

OnesRun.setOnes(getCurrentValueOnes());

while ( (number = readNumbersFromFile) != null) {
   threadPool.execute(new OnesRun(number));
}

print("Overall values of ones " + OnesRun.getOnes());