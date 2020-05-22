public class MyAggregationStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange aggregatingExchange, Exchange incomingExchange) {
        AppPayload payload = null;

        if(aggregatingExchange == null) {
        payload = new AppPayload(); // This should prevent it from being NULL below in PostProcessor...
        } else {
            payload = (AppPayload)aggregatingExchange.getIn().getBody();
        }

        payload.setCargo((Order)incomingExchange.getIn().getBody());

        if(aggregatingExchange == null) {
            incomingExchange.getIn().setBody(payload);
            return incomingExchange;
        } else {
            return aggregatingExchange;
        }
    }
}