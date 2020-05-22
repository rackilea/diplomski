ExecutorService es = Executors.newFixedThreadPool(5);
public void doStuff() {
    Collection<Callable> tasks = Arrays.asList(new Callable[]
            { new FirstTask(), new SecondTask() });
    es.invokeAll(tasks);
}