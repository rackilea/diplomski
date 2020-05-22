private static final int MAX_TRIES = 3;
private static final int RETRY_INTERVAL_IN_MILLISECONDS = 100;

@Mock
private Callable<String> mockCallable;

@Test
public void testQueryConfigThrowsRandomExceptionOnTimeout() throws Exception {
    when(mockCallable.call()).thenThrow(new IllegalArgumentException("timeout"));
    try {
        queryWithRetry(mockCallable, MAX_TRIES, RETRY_INTERVAL_IN_MILLISECONDS);
        fail("should have thrown");
    } catch (RuntimeException re) {
        // as expected
    }
    verify(mockCallable, Mockito.times(3)).call();
}