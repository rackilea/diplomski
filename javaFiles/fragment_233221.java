public void configure() throws Exception {
        restConfiguration().component("undertow").host("localhost").port(8080).bindingMode(RestBindingMode.auto);
        rest("/B").put("/call")
                .consumes("application/json")
                //.type(BRequest.class)
                .to("direct:doB");

        from("direct:doB")
        .to("log:com.mycompany.B?showAll=true&multiline=true")
                .marshal().json(JsonLibrary.Jackson)

                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .to("log:com.mycompany.BeforeSendingToA?showAll=true&multiline=true")
                .to("http4://localhost:8080/A/callResponse?bridgeEndpoint=true")
                .to("log:com.mycompany.AfterSendingToA?showAll=true&multiline=true")
                .end(); 
}