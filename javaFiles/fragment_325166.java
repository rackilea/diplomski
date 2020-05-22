@Before
  public void setUp() throws Exception {
    super.setUp();
    context.getRouteDefinition("MyRoute").adviceWith(context, new AdviceWithRouteBuilder() {
      @Override
      public void configure() throws Exception {
        weaveById("MyEndPointId").replace().to("mock:MyMockEndpoint");
      }
});