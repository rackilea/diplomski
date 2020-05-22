@Singleton
public class SomeSingleton {
    public void fireStream() {
        IntStream.range(0, 32)
            .parallel()
            .mapToObj(i -> String.format("Task %d on thread %s", 
                i, Thread.currentThread().getName()))
            .forEach(System.out::println);
    }
}