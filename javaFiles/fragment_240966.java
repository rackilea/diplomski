ExecutorService exec = Executors.newFixedThreadPool(8);
List<Future<Object>> results = new ArrayList<Future<Object>>();

// submit tasks
for(int i = 0; i < 8; i++) {
    results.add(exec.submit(new ThreadTask()));
}

...

// stop the pool from accepting new tasks
exec.shutdown();

// wait for results
for(Future<Object> result: results) {
    Object obj = result.get();
}