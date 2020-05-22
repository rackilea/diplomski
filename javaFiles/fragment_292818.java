import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.ArrayOperators.Filter.filter;
import static org.springframework.data.mongodb.core.aggregation.ComparisonOperators.Eq.valueOf;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.aggregation.*;

List<AggregationOperation> aggregators;
MatchOperation match = Aggregation.match(Criteria.where("parentId").is(myId));
List<String> domains = Arrays.asList("issues", "bugs", "errors");
for (Iterator<String> d = domains.iterator(); d.hasNext();) {
     String domain = d.next();
     aggregators = new ArrayList<>();
     ProjectionOperation project = project().and(filter(domain)
                        .as("myObject")
                        .by(valueOf(
                                "myObject.closed")
                                .equalToValue(
                                       true)))
                        .as("closedProblems");
     aggregators.add(match);
     aggregators.add(project);
     Aggregation aggregation = newAggregation(aggregators).withOptions(newAggregationOptions().cursor(new Document()).build());
     AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "myColl", Document.class );
     for (Document result : results) {
                    // ...
    }
}