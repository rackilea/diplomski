import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

Aggregation aggregation = newAggregation(
        sort(Sort.Direction.ASC, "product", "version", "createdDate"), 
        group("product").last("$$ROOT").as("root"),
        sort(Sort.Direction.ASC, "_id"),
        //$replaceRoot
        );

return mongoTemplate.aggregate(aggregation, Product.class, Product.class).getMappedResults();