@Test
public void whenRunnerThrows_thenReturn5xx() throws Exception {
    CompletableFuture<String> badFuture = new CompletableFuture<>();
    badFuture.completeExceptionally(new Exception(""));
    when(service.runAsync(any(),any())).thenReturn(badFuture);

    mvc.perform(post("/test")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"test\"}"))
            .andExpect(status().is5xxServerError());
}