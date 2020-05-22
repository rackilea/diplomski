public class DoSomething {
    @SuppressWarnings("unused") //called via Camel bean invocation
    public void doSomething(Exchange exchange){
        exchange.getContext().createProducerTemplate().sendBody("direct:log", "I am body and I will be passed to EventStatusProcessor");
    }
}