@Test
public void shouldExtractContentAsStringFromAResultUsingAMaterializer() throws Exception {
    ActorSystem actorSystem = ActorSystem.create("TestSystem");

    try {
        Materializer mat = ActorMaterializer.create(actorSystem);

        Result result = Results.ok("Test content");
        String contentAsString = Helpers.contentAsString(result, mat);
        assertThat(contentAsString, equalTo("Test content"));
    } finally {
        Future<Terminated> future = actorSystem.terminate();
        Await.result(future, Duration.create("5s"));
    }
}