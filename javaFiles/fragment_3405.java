ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4));
int runs = 100;
for (int k=0; k < runs; k++) {
    Callable<Integer> job = ...; // create the job here
    ListenableFuture<Integer> completion = executor.submit(job);
    Futures.addCallback(completion, new FutureCallback<Integer>() {

        @Override
        public void onFailure(Throwable t) {
            // log error
        }

        @Override
        public void onSuccess(Integer result) {
            // do something with the result
        }

    });
}
executor.shutdown();
while (!executor.isTerminated()) {
    executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
}