package postman;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

@Service
public class PostmanService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<PostSummary> find(String userId){

        Aggregation aggregation = Aggregation.newAggregation(
            match(new Criteria()),
            //lookup("users", "postedBy", "_id", "user")
            new AggregationOperation() {
                @Override
                public Document toDocument(AggregationOperationContext context) {
                    return new Document("$lookup",
                        new Document("from", "users")
                            .append("let", new Document("postedBy", "$postedBy"))
                            .append("pipeline", Arrays.asList(
                                new Document("$match", 
                                    new Document("$expr", 
                                        new Document("$eq", Arrays.asList(
                                            new Document("$toString", "$_id"),
                                            "$$postedBy"
                                        ))))))
                            .append("as", "user"));
                }
            },
            unwind("$user"),
            new AggregationOperation() {

                @Override
                public Document toDocument(AggregationOperationContext context) {
                    return new Document("$addFields",
                        new Document("id", new Document("$toString", "$_id"))
                        .append("username", "$user.name")
                        .append("upvotes", new Document("$size", "$upvotesBy"))
                        .append("isUpvoted", new Document("$in", Arrays.asList(userId, "$upvotesBy")))
                        .append("isPinned", new Document("$cond", 
                            Arrays.asList(new Document("$gte", 
                                    Arrays.asList(new Document("$size", "$upvotesBy"), 3)), Boolean.TRUE, Boolean.FALSE)))
                        .append("createdAt", new Document("$dateToString", 
                            new Document("format", "%H:%M %d-%m-%Y")
                                .append("timezone", "+01")
                                .append("date", "$createdAt")
                            )));
                }
            },
            sort(Direction.DESC, "isPinned", "createdAt"),
            project().andExclude("user", "_class")
        );

        System.out.println("Aggregation: " + aggregation.toString());

        return mongoTemplate.aggregate(aggregation, mongoTemplate.getCollectionName(Post.class), PostSummary.class).getMappedResults();
    }
}