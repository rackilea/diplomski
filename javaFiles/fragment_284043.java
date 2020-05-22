AtomicInteger counter = new AtomicInteger(0);

Stream<String> personStream = persons
  .stream()
  .map(WorkflowTest::mapToJsonString)
  .peek(str -> counter.incrementAndGet());