public class Main {
    static void doWork(int task) {
        try {
            System.out.println("starting " + task);
            // business logic
            Thread.sleep(10000);
            System.out.println("... finished " + task);
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 100_000)
                .parallel()
                .forEach(Main::doWork);
    }
}