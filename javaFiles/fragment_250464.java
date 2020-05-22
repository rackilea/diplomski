/* in the system under test */
@VisibleForTesting Thread generateAndReturnThread() {
  Thread thread = new Thread(this);
  thread.start();
  return thread;
}

public void generateThread() {
  generateAndReturnThread();
}

/* in the test */
@Test public void yourTest() {
  ThreadGenerator threadGenerator = new ThreadGenerator();
  threadGenerator.setRequestLimit(1);

  // wait up to a second for thread to complete
  threadGenerator.generateThreadAndReturn().join(1000);

  assertEquals(threadGenerator.getRequests(), 1);
}