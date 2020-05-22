class Method1Task implements Callable<Void> {
    public Void call() throws Exception {
        // method 1 body here
        return null;
    }
}

class Method2Task implements Callable<Void> {
    public Void call() throws Exception {
        // method 2 body here
        return null;
    }
}

...

// Create a single-thread pool and use it to submit tasks
private final ExecutorService executor = Executors.newFixedThreadPool(1);

void method1() {
    executor.submit(new Method1Task());
}

void method2() {
    executor.submit(new Method2Task());
}