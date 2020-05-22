from("source1").to("direct:aggregateRoute"); 
from("source2").to("direct:aggregateRoute"); 
from("direct:aggregateRoute")
    .filter(header("isEndMessage").isEqualTo("true"))
        .aggregate(constant(true), new MyAggregationStrategy())
        .completionPredicate(new MyCompletionStrategy())
    .to("destination");