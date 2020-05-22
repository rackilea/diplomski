ExecutorService EXEC = Executors.newCachedThreadPool();
List<Callable<Result>> tasks = new ArrayList<Callable<Result>>();
for (final Object object: objects) {
    Callable<Result> c = new Callable<Result>() {
        @Override
        public Result call() throws Exception {
            return compute(object);
        }
    };
    tasks.add(c);
}
List<Future<Result>> results = EXEC.invokeAll(tasks);