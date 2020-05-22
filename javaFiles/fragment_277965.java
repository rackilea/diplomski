@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(VertxUnitRunner.class)
@PrepareForTest({ MongoClient.class })
public class PersistenceTest {

private MongoClient mongo;
private Vertx vertx;

@Before
public void initSingleTest(TestContext ctx) throws Exception {
  vertx = Vertx.vertx();
  mongo = Mockito.mock(MongoClient.class);
  PowerMockito.mockStatic(MongoClient.class);
  PowerMockito.when(MongoClient.createShared(Mockito.any(), Mockito.any())).thenReturn(mongo);
  vertx.deployVerticle(Persistence.class, new DeploymentOptions(), ctx.asyncAssertSuccess());
}

@SuppressWarnings("unchecked")
@Test
public void loadSomeDocs(TestContext ctx) {
  Doc expected = new Doc();
  expected.setName("report");
  expected.setPreview("loremipsum");
  Message<JsonObject> msg = Mockito.mock(Message.class);
  Mockito.when(msg.body()).thenReturn(JsonObject.mapFrom(expected));
  JsonObject result = new JsonObject().put("name", "report").put("preview", "loremipsum");
  AsyncResult<JsonObject> asyncResult = Mockito.mock(AsyncResult.class);
  Mockito.when(asyncResult.succeeded()).thenReturn(true);
  Mockito.when(asyncResult.result()).thenReturn(result);
  Mockito.doAnswer(new Answer<AsyncResult<JsonObject>>() {
    @Override
    public AsyncResult<JsonObject> answer(InvocationOnMock arg0) throws Throwable {
    ((Handler<AsyncResult<JsonObject>>) arg0.getArgument(3)).handle(asyncResult);
    return null;
    }
  }).when(mongo).findOne(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
  Async async = ctx.async();
  vertx.eventBus().send("persistence", new JsonObject(), msgh -> {
    if (msgh.failed()) {
    System.out.println(msgh.cause().getMessage());
    }
    ctx.assertTrue(msgh.succeeded());
    ctx.assertEquals(expected, Json.decodeValue(msgh.result().body().toString(), Doc.class));
    async.complete();
  });
  async.await();
  }
}