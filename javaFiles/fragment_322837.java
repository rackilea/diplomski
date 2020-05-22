List<Callable> jobs = new ArrayList<>(requests.size());
for (String request : requests) {
    jobs.add(new MyCallable(request));
}
List<Future<ProcessedResponse>> futures = executor.invokeAll(jobs, timeout, TimeUnit.MILLISECONDS);
Iterator<String> it = requests.iterator();
for (Future<ProcessedResponse> future: futures) {
    String request = it.next();  // This request corresponds to this future
    if (future.isDone()) {
        results.add(new Result(request, future.get()));
    } else {
        future.cancel(true);
    }
}