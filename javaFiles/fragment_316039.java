public class StringAggregator implements AggregationStrategy {

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }
        else {
            String oldBody = oldExchange.getIn().getBody(String.class);
            String newBody = oldBody + ", " + newExchange.getIn().getBody(String.class);
            newExchange.getIn().setBody(newBody);
            return newExchange;
        }
    }
}