CamelContext camelContext = new DefaultCamelContext();
camelContext.addRoutes(new RouteBuilder() {
  @Override
  public void configure() {
    from("file:data/inbox?noop=true") // consumer
      .to("file:data/outbox");        // producer
  }
});
camelContext.start();
Thread.sleep(2000);
camelContext.stop();