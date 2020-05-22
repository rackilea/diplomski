import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.elasticsearch.search.aggregations.Aggregation;

//process ES Response, it will iterate only once though
// sr = searchResponse
for (Aggregation maxAggs : sr.getAggregations()) {
              Max max = (Max) maxAggs;
              double maxValue = max.getValue();
              System.out.println("maxValue => " + maxValue);
}