@Test
public void yourTest() throws Exception {

  // Do commands 1-2

  ExecutorService service = Executors.newSingleThreadExecutor();
  Future<Void> result = service.submit(new Callable<Void>() {
    @Override
    public Void call() throws Exception {
      // call commands 3-5
      return null;
    }
  });

  try {
    result.get(42, TimeUnit.MILLISECONDS);
  } catch (TimeoutException e) {
    throw new YourOwnException();
  }

  service.shutdown();

  // Do commands 6-10
}