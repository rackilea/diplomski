ExecutorService service = Executors.newFixedThreadPool(N);
volatile boolean done = false;

// add your jobs:
service.submit(() -> {
    while (!done) {
        // do something
    }
});

// set your flag
done = true;