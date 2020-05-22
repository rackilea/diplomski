http()
.client(wiremockClient)
.receive()
.response(HttpStatus.OK)
.messageType(MessageType.JSON)
.payload("{\n"+
    "  \"requests\": {\n"+
    "    \"id\": \"52844d5a-59de-4288-8000-7f48fcda41e5\",\n"+
    "    \"request\": {\n"+
    "      \"body\": \"@matchesXml('<soapenv:Envelope xmlns:soapenv=\\\"http://schemas.xmlsoap.org/soap/envelope/\\\"> [content omitted] </soapenv:Body></soapenv:Envelope>')@\"\n"+
    "    }\n"+
    "  }\n"+
    "}");