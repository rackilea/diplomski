ExecutorService service = Executors.newCachedThreadPool();
// or
ExecutorService service = Executors.newFixedThreadPool(THREADS);

// submit as many tasks as you want.
// tasks must honour interrupts to be stopped externally.
Future future = service.submit(new MyRunnable());

// to cancel an individual task
future.cancel(true);

// when finished shutdown
service.shutdown();