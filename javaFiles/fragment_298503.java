context.getRouteDefinition("yourRouteId").adviceWith(context, new AdviceWithRouteBuilder() {
  @Override
  public void configure() throws Exception {
    weaveById("yourEndpointId").replace().setBody(new ConstantExpression("whateveryouwant"
     ));
  }

});