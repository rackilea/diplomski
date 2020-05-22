from("direct:getContact")
    .marshal().json(JsonLibrary.Jackson)
    .setHeader("Content-Type", constant("application/json"))
    .setHeader("Accept", constant("application/json"))
    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
    .removeHeader(Exchange.HTTP_PATH)
    .recipientList(simple("http://<remoteHost>:8080/api/contact" +
        "/${header.contactId}?bridgeEndpoint=true"))
    .unmarshal().json(JsonLibrary.Jackson);