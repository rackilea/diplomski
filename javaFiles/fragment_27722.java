import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class StringAggregator implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange old, Exchange new1) {
        if (old == null) { 
            return new1;
        }

        String oldBody = old.getIn().getBody(String.class);
        String newBody = new1.getIn().getBody(String.class);
        old.getIn().setBody(oldBody + " " + newBody);
        return old;

    }

}