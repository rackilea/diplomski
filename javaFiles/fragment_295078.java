public class ProductPriceAggregator implements AggregationStrategy {

@Override
public Exchange aggregate(Exchange oldExchange, Exchange newExchange) 
{

    if (oldExchange == null) {
       // the first time we aggregate we only have the new exchange,
       // so we just return it
       return newExchange;
    }

    System.out.println("FOO BAR");
    double oldPrice = oldExchange.getIn().getBody(Double.class);
    double newPrice = newExchange.getIn().getBody(Double.class);
    double finalPrice = oldPrice > newPrice ? newPrice : oldPrice;
    oldExchange.getIn().setBody(finalPrice);
    return oldExchange;
  }
}