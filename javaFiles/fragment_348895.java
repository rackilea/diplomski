ListeningExecutorService executor = ...
List<Callable<Foo>> tasks = ...

List<ListenableFuture<Foo>> futures = Lists.newArrayList();
for (Callable<Foo> task : tasks) {
  futures.add(executor.submit(task));
}

final ListenableFuture<List<Foo>> resultsFuture
    = Futures.allAsList(futures);

// block until all tasks are done
List<Foo> results = resultsFuture.get();

// or add a callback to get called when the tasks complete
Futures.addCallback(resultsFuture, new FutureCallback<List<Foo>>() {
  @Override public void onSuccess(List<Foo> results) {
    // ...
  }

  @Override public void onFailure(Throwable throwable) {
    // ...
  }
}, someExecutor);