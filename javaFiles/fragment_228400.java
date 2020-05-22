@SpyBean
private RecordCreationService recordCreationServiceSpy;

@Test(timeout = 10_000)
public void recordShouldBeCreatedWhenDataIsUpdated() {
    // Set up test here

    updateValueAndWait(value);

    assertEquals(1, recordRepository.findAll().size());
    // Perform any additional verifications
}

private void updateValueAndWait(String value) {
    CountDownLatch latch = new CountDownLatch(1);
    Mockito.doAnswer(invocation -> {
        Object result = invocation.callRealMethod();
        latch.countDown();
        return result;
    }).when(recordCreationServiceSpy).insertRecord(any());

    testClass.update(value);

    try {
        latch.await();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}