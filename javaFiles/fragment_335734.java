ExecutorService es = Executors.newSingleThreadedPool();

// set a runnable later.
es.submit(new MyRunnable());

// give it another runnable when that finishes.
es.submit(new MyRunnable2());

// don't need it any more
es.shutdown();