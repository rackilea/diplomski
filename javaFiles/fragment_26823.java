@Test
public void test() throws InterruptedException, CamelExecutionException, IOException {
    getMockEndpoint("mock:output").expectedBodyReceived().body().contains("{\"books\"");
    getMockEndpoint("mock:output").expectedMessageCount(1);


    template.sendBody("direct:input", 
                    IOUtils.toString(this.getClass().getResourceAsStream("/xml/books.xml"), 
                                    Charset.defaultCharset()));

    getMockEndpoint("mock:output").assertIsSatisfied();
}