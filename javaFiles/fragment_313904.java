private final Executor executor = Executors.newSingleThreadExecutor();

public void doSomethingWith(final Object obj) {
    executor.execute(new Runnable() {

        public void run() {
            // Do something with obj
        }
    });
}