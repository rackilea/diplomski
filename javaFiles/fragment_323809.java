List<Callable<Object>> calls = new ArrayList<Callable<Object>>();
calls.add(Executors.callable(new IncrementalRunable(1, aHolder)));
calls.add(Executors.callable(new IncrementalRunable(2, aHolder)));
calls.add(Executors.callable(new IncrementalRunable(3, aHolder)));

List<Future<Object>> futures = executor.invokeAll(calls);