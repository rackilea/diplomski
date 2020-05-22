@Test
public void completeExceptionallyOnCallbackFailure() {
    ListenableFuture<UserRecordResult> failureResponse = Futures.immediateFailedFuture(new RuntimeException());
    CompletableFuture future = new CompletableFuture();

    handleResponse(failureResponse, future);

    assertThat(future.isCompletedExceptionally(), equalTo(true));
}

@Test
public void completeExceptionallyIfUserRecordResultIsNotSuccessful() {
    UserRecordResult mockResult = Mockito.mock(UserRecordResult.class);
    Mockito.when(mockResult.isSuccessful()).thenReturn(false);

    ListenableFuture<UserRecordResult> failureResponse = Futures.immediateFuture(mockResult);
    CompletableFuture future = new CompletableFuture();

    handleResponse(failureResponse, future);

    assertThat(future.isCompletedExceptionally(), equalTo(true));
}

@Test
public void completeSuccessfully() throws ExecutionException, InterruptedException {
    UserRecordResult mockResult = Mockito.mock(UserRecordResult.class);
    Mockito.when(mockResult.isSuccessful()).thenReturn(true);

    ListenableFuture<UserRecordResult> successResponse = Futures.immediateFuture(mockResult);
    CompletableFuture future = new CompletableFuture();

    handleResponse(successResponse, future);

    assertThat(future.get(), equalTo(true));
}