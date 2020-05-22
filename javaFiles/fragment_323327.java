final AggregationBuilder<?> dailyDateHistogarm =
   AggregationBuilders.dateHistogram(AggregationConstants.DAILY)
        .field("dob")        
        .minDocCount(0)                          <--- add this line
        .interval(DateHistogram.Interval.DAY)
        .subAggregation(aggregateArtifactcount);