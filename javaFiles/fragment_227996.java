ExecutorService executor = getExecutorService();
List<Request> requests = getRequests();
List<Callable> tasks = requests.stream()
    .map(r -> new Processor(r))
    .collect(Collectors.toList());

executor.invokeAll(tasks);