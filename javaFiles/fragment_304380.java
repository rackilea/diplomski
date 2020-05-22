public class CamelHeadersAndRows {
    public static class HeaderBean {
        String header = null;
        public void setHeader(String body) {
            header = body.substring("01,".length());
        }
        public String useHeader(String body) {
            return header + "," + body.substring("02,".length());
        }
    }

    public static void main(String[] args) throws Exception {
        final HeaderBean headerBean = new HeaderBean();

        Main camelMain = new Main();
        camelMain.addRouteBuilder(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:foo?period=1s&repeatCount=1")
                        .setBody(constant(
                                "01,H2,H3\n" +
                                "02,B2,B3,B4,B5\n" +
                                "02,B2,B3,B4,B5\n" +
                                "02,B2,B3,B4,B5\n" +
                                "02,B2,B3,B4,B5\n" +
                                "01,H2,H3\n" +
                                "02,B2,B3,B4,B5\n" +
                                "02,B2,B3,B4,B5\n" +
                                "01,H2,H3\n" +
                                "02,B2,B3,B4,B5\n" +
                                "02,B2,B3,B4,B5\n" +
                                "02,B2,B3,B4,B5"
                        ))
                        .to("direct:inventory");

                from("direct:inventory")
                        .split(body().tokenize("\n")).streaming()
                        .choice()
                            .when().simple("${body} regex '^01.*'")
                                .bean(headerBean, "setHeader")
                                .stop()
                            .otherwise()
                                .bean(headerBean, "useHeader")
                        .end()
                        .log("message: ${body}")
                ;
            }
        });
        camelMain.run();
    }

}