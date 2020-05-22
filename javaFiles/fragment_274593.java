import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

Aggregation agg = newAggregation(match(where("st").is("i").and("@").gte(new Date()).lte(new Date()).and("c").is("REQ_RCV")),
            group(fields("b").and("HOURLY", "$@h")).count().as("count"),
            sort(ASC, Aggregation.previousOperation()));

List<BasicDBObject> dbObjects = mongoOperations.aggregate(agg, "collection_name", BasicDBObject.class).getMappedResults();