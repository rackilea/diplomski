public class Counter {
    private final AtomicInteger i = new AtomicInteger(1);

    public void add() {
        for (;;)
        {
            int localCount = i.getAndIncrement();
            if (localCount > 5) { break; }

            System.out.println(localCount + " " + Thread.currentThread().getName());
        }
    }
}