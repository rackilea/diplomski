import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StatefulObject {

    private static final int NUMBER_OF_THREADS = 10;

    private volatile State state;

    public StatefulObject() {
        state = new State();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static class State {
        private volatile AtomicInteger counter;

        public State() {
            counter = new AtomicInteger();
        }

        public AtomicInteger getCounter() {
            return counter;
        }

        public void setCounter(AtomicInteger counter) {
            this.counter = counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StatefulObject object = new StatefulObject();

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        AtomicInteger oldCounter = new AtomicInteger();
        AtomicInteger newCounter = new AtomicInteger();

        object.getState().setCounter(oldCounter);

        List<Long> oldList = new CopyOnWriteArrayList<>();
        List<Long> newList = new CopyOnWriteArrayList<>();

        List<Future> futures = IntStream.range(0, NUMBER_OF_THREADS)
            .mapToObj(num -> executorService.submit(() -> {
                for (int i = 0; i < 1000; i++) {
                    long l = System.nanoTime();
                    object.getState().getCounter().incrementAndGet();
                    if (object.getState().getCounter().equals(oldCounter)) {
                        oldList.add(l);
                    } else {
                        newList.add(l);
                    }
                }
            })).collect(Collectors.toList());

        executorService.shutdown();

        object.getState().setCounter(newCounter);

        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("Counter: %s\n", object.getState().getCounter().get());
        Collections.sort(oldList);
        Collections.sort(newList);
        long lastSeenOld = oldList.get(oldList.size() - 1);
        long firstSeenNew = newList.get(0);
        System.out.printf("Last seen old counter: %s\n", lastSeenOld);
        System.out.printf("First seen new counter: %s\n", firstSeenNew);
        System.out.printf("Old was seen after the new: %s\n", lastSeenOld > firstSeenNew);
        System.out.printf("Old was seen %s nanoseconds after the new\n", lastSeenOld - firstSeenNew);
    }
}