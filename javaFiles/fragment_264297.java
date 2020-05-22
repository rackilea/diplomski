public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() {
        from("file:zipper/in?include=.*.xml&noop=true")
            .process(new Processor() {
                @Override
                public void process(final Exchange exchange) throws Exception {
                    exchange.setProperty("myZipName", "messages.zip");
                }
            })
            .aggregate(new MyZipAggregationStrategy())
            .constant(true)
            .completionFromBatchConsumer()
            .eagerCheckCompletion()
            .setHeader(Exchange.FILE_NAME, simple("${property.myZipName}")) // setting ZIP file name
            .to("file:zipper/out");
    }
}