import java.util.concurrent.atomic.AtomicInteger;

class Singleton { 
    // singleton logic ommited
    private AtomicInteger counter = new AtomicInteger();

    public int getCounter() {
        return counter.incrementAndGet();
    }
}