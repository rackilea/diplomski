public void configure() {
    restConfiguration().component("undertow").host("localhost").port(8080).bindingMode(RestBindingMode.auto);
    from("timer://myTimer?period=600s")
            .setBody(constant("{\"hello\":\"hello\"}"))
            .setHeader(Exchange.HTTP_METHOD, constant("PUT"))
            .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))

            .marshal().json(JsonLibrary.Jackson)
            .to("http4://localhost:8080/B/call")
            .end();

    rest("/A").post("callResponse")
            .consumes("application/json")
            .to("seda:handle");

    from("seda:handle")
    .to("log:com.mycompany.handle?showAll=true&multiline=true")
            .to("stream:out")
            .end();
}