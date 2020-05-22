Aggregation agg = newAggregation(
    project()       
        .andExpression("year(receivedDate)").as("year")
        .andExpression("month(receivedDate)").as("month")
        .andExpression("dayOfMonth(receivedDate)").as("day"),
    group(fields().and("year").and("month").and("day"))     
        .count().as("count")
);