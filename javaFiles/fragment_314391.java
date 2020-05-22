import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

GroupAggregationOperation groupOp = new GroupAggregationOperation(operation);
Aggregation agg = newAggregation(
    match(Criteria.where("deletedAt").exists(false)),
    sort(ASC, "deletedAt"),
    groupOp 
);
AggregationResults<Forms> results = mongoTemplate.aggregate(agg, Forms.class); 
List<Forms> forms = results.getMappedResults();