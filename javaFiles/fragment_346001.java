public class MyStrategy implements AggregationStrategy {

  @Override
  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    List<String> someValue  = Lists.newArrayList();

    if(oldExchange == null) {
      List<String> valueHeader = (List<String>) newExchange.getIn().getHeader("SomeKey");
      if (CollectionUtils.isEmpty(valueHeader)) {
        newExchange.getIn().setHeader("SomeKey", Lists.newArrayList("dummyValue"));
      }
      return newExchange;
    }
    List<String> valueHeader = (List<String>) oldExchange.getIn().getHeader("SomeKey");
    someValue.addAll(valueHeader);
    return oldExchange;
  }
}