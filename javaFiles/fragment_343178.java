public class MyProcessor implements Processor {
    @Override
    public void process(Exchange exchange) {
        String body = exchange.getIn().getBody(String.class);
        //Perform some logic and put it back in the exchange
        exchange.getIn().setBody(body);
    }
}