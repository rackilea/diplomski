CamelContext context = new DefaultCamelContext();
context.addRoutes(new RouteBuilder()
{
    Predicate predicate = PredicateBuilder.and(simple("${file:name.ext} == 'txt'"), XPathBuilder.xpath("/author/country = 'us'"));
    public void configure() throws Exception
    {
        from("file:C:\\camels\\inner?delete=true")
            .choice()
                .when(predicate)
                    .to("file:C:\\testing");
    }
});
context.start();
Thread.sleep(10000);
context.stop();