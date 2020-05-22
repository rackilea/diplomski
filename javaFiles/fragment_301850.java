class DoSomething {
    @SuppressWarnings("unused") //called via Camel bean invocation
    public void doSomething(Exchange exchange){
        exchange.setProperty("propertyFromDoSomething", "Hello, I am property");
        exchange.getIn().setHeader("headerFromDoSomething", "Hi, I am header");
        exchange.getIn().setBody("It's me, body!");
    }
}

class EventStatusProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getHeader("headerFromDoSomething", String.class));
        System.out.println(exchange.getProperty("propertyFromDoSomething", String.class));
        System.out.println(exchange.getIn().getBody(String.class));
    }
}