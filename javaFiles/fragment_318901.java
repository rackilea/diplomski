ExecutorService executorService = ...
    Object res = executorService.submit(new Callable<Object>() {
        public Object call() throws Exception {
            ... your logic
        }
    }).get(timeout, TimeUnit.MILLISECONDS);