AggregationResults<DBObject> result = mongoTemplate.aggregate(
  Aggregation.newAggregation(
    Aggregation.group().count().as("value"), 
    Aggregation.project("value").andExclude("_id"), 
MyData.class, DBObject.class);

int count = (Integer) result.getUniqueMappedResult().get("value");