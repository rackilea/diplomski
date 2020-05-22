public class RserveCamel {
    public static class StoringBean {
        private REXP payload;
        public REXP getPayload() {
            return payload;
        }
        public void setPayload(REXP payload) {
            this.payload = payload;
        }
    }
    public static void main(String args[]) throws Exception {
        StoringBean storingBean = new StoringBean();

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:rcode")
                    .to("rcode:localhost:6311/eval?bufferSize=4194304")
                    .to("log:test?showBody=true&showHeaders=false")
                    .bean(storingBean, "setPayload");
            }
        });
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        context.start();
        producerTemplate.sendBody("direct:rcode", "c <- 4; print(c);");
        context.stop();
        System.out.println(storingBean.getPayload().asString());
    }
}