public class LongRecipientListCausesStackOverflow extends CamelTestSupport {

    private static final int COUNT = 300;
    private static final String BASE_DIR = "D://temp/cameltest/";

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:in")
                        .recipientList(header("to"))
                        .to("mock:done");
            }
        };
    }

    @Before
    public void clenup() throws Exception{
        FileUtils.deleteDirectory(new File(BASE_DIR));
    }

    @Test
    public void fails() throws Exception { //fails, throws StackOverflowError with header("to") of type String
        MockEndpoint mockEndpoint = getMockEndpoint("mock:done");
        String recipientListString = IntStream.range(0,COUNT).mapToObj(subDir -> "file:"+BASE_DIR+subDir).collect(Collectors.joining(","));
        template.sendBodyAndHeader("direct:in","", "to", recipientListString);
        mockEndpoint.assertIsSatisfied();
        Assert.assertEquals(COUNT, new File(BASE_DIR).listFiles().length);
    }

    @Test
    public void passes() throws Exception { //pass with header("to") of type List<String>
        MockEndpoint mockEndpoint = getMockEndpoint("mock:done");
        List<String> recipientListList = IntStream.range(0,COUNT).mapToObj(subDir -> "file:"+BASE_DIR+subDir).collect(Collectors.toList());
        template.sendBodyAndHeader("direct:in","", "to", recipientListList);
        mockEndpoint.assertIsSatisfied();
        Assert.assertEquals(COUNT, new File(BASE_DIR).listFiles().length);
    }
}