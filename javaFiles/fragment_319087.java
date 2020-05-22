public static class SimpleBean {
    public List<Object> constructObject() {
           List<Object> objects = new ArrayList<>();
           objects.add("entry");
           return objects;
         }
}

@Override
protected RouteBuilder createRouteBuilder() {
    return new RouteBuilder() {

        public void configure() {
            from("direct:start")
            .bean(SimpleBean.class, "constructObject")
            .marshal().json(JsonLibrary.Jackson)
            .setHeader(Exchange.FILE_NAME, constant("test.json"))
            .to("file:C:/tmp/JSON");
        }
    };
}