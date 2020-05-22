public class MyTests {

  protected Application application;

  @Before
  public void startApp() throws Exception {
    ClassLoader classLoader = FakeApplication.class.getClassLoader();
    application = new GuiceApplicationBuilder().in(classLoader)
            .in(Mode.TEST).build();
    Helpers.start(application);
  }

  @Test
  public void myPostActionTest() throws Exception {

    JsonNode jsonNode = (new ObjectMapper()).readTree("{ \"someName\": \"sameValue\" }");
    RequestBuilder request = new RequestBuilder().method("POST")
            .bodyJson(jsonNode)
            .uri(controllers.routes.MyController.myAction().url());
    Result result = route(request);

    assertThat(result.status()).isEqualTo(OK);
  }

  @After
  public void stopApp() throws Exception {
    Helpers.stop(application);
  }
}