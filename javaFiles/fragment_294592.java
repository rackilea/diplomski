@Test
public void testName() throws Exception {
    context.addRoutes(new RouteBuilder() {
        @Override
        public void configure() throws Exception {
            from("direct:a").dynamicRouter().method(new WhereToGo());
            from("direct-vm://step1").log("Step1: ${body}");
            from("direct-vm://step2").log("Step2: ${body}");
        }
    });

    template.sendBody("direct:a", "data");
    Thread.sleep(6000);
}