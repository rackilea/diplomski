public static final String FILE_ROUTE_ID = "file.route";
public static final String FILE_ROUTE_URI = "{{file.route.uri}}";

@Override
public void configure() throws Exception {

    from(FILE_ROUTE_URI)
            .routeId(FILE_ROUTE_ID)
            .log(LoggingLevel.INFO, "Header {}", String.valueOf(simple("${header.purpose}")))
            .from("file:apache-camel-spring-boot?fileName=printing.key&noop=true")
            .convertBodyTo(String.class)
            .process(exchange -> {
                log.info("Processing file . . .");
                KeyBody keyBody = new KeyBody(exchange.getIn().getBody(String.class));
                exchange.getIn().setBody(keyBody);
            });
}