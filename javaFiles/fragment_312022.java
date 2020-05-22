Thread threadServeThatRunsOn;

@Test
public void serveThatWillBeExecutedAsynchronously() throws Exception {
    doAnswer(invocation -> {
        threadServeThatRunsOn = Thread.currentThread();
        return null;
    }).when(mockService).serveThat();

    testObject.doSomething();

    verify(mockService, timeout(200)).serveThat();
    assertNotEquals(threadServeThatRunsOn, Thread.currentThread());
}