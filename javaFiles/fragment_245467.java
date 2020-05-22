@EndpointInject(uri = "mock:mock")
protected MockEndpoint mock;

@Test
public void test() throws Exception {
    mock.expectedMessageCount(2);
    mock.expectedHeaderReceived("foo","bar");
    template.sendBodyAndHeader("direct:start", "msg1,msg2", "foo", "bar");
    assertMockEndpointsSatisfied();
}

@Override
protected RouteBuilder createRouteBuilder() throws Exception {
    return new RouteBuilder() {
        @Override
        public void configure() throws Exception {

            from("direct:start")
                .to("log:+++before+++?showHeaders=true")
                .split().method(MySplitterBean.class, "splitBody").streaming()
                .to("log:+++after+++?showHeaders=true")
                .choice().when(header("foo").contains("bar"))
                    .to("mock:mock")
                .otherwise()
                    .to("mock:error");
        }
    };
}

public static class MySplitterBean {
    public List<String> splitBody(String body) {
        List<String> answer = new ArrayList<String>();
        String[] parts = body.split(",");
        for (String part : parts) {
            answer.add(part);
        }
        return answer;
    }
}