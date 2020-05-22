import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.*;
import org.springframework.data.mongodb.core.query.Criteria;

Cond operatorNbS = ConditionalOperators.when("scst").thenValueOf(1).otherwise(0);
Cond operatorNbE = ConditionalOperators.when("scst").thenValueOf(0).otherwise(1);

Aggregation agg = newAggregation(
    match(Criteria.where("bid").is("build_1481711758"),
    project("bid") 
        .and("scst")                            
        .applyCondition(operatorNbE, field("nbE"))
        .applyCondition(operatorNbS, field("nbS"))
    group("bid")
        .count().as("nb")
        .sum("nbE").as("nbS")
        .sum("nbE").as("nbE") 
);
AggregationResults<Scenarios> results = mongoTemplate.aggregate(agg, Scenarios.class); 
List<Scenarios> scenarios = results.getMappedResults();