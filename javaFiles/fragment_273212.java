@Test
public void verifyMessageIfCompletedExceptionallyAfterUserRecordResultIsNotSuccessful() {
    UserRecordResult mockResult = Mockito.mock(UserRecordResult.class);
    Mockito.when(mockResult.isSuccessful()).thenReturn(false);

    ListenableFuture<UserRecordResult> failureResponse = Futures.immediateFuture(mockResult);
    CompletableFuture future = new CompletableFuture();

    Assertions.assertThatThrownBy(() -> {
        handleResponse(failureResponse, future);
        future.get();
    })
    .isInstanceOf(Exception.class)
    .hasMessage("java.lang.Exception: Fail to put record");
}