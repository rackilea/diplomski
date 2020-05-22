public class MyZipAggregationStrategy extends ZipAggregationStrategy {
    @Override
    public Exchange aggregate(final Exchange oldExchange, final Exchange newExchange) {
        final Exchange answer = super.aggregate(oldExchange, newExchange);
        answer.setProperty("myZipName", newExchange.getProperty("myZipName")); // Hack!!
        return answer;
    }
}