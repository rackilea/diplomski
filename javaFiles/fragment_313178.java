CustomSampleOperation customSampleOperation = new CustomSampleOperation(1);
TypedAggregation<Story> typedAggr = Aggregation.newAggregation(Story.class, 
    customSampleperation);

AggregationResults<Story> aggregationResults = mongoTemplate.aggregate(typedAggr, Story.class);
aggregationResults.getMappedResults().get(0);