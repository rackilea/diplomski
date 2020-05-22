import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.asList;
List<Document> results = mongoCollection.aggregate(
   asList(
      match(
            and(
                  eq("port", "GOOD_PRODUCT_COUNT"),
                  eq("serial", "MDC-SBO"),
                  eq("x", "y"),
                  gte("collected", new Date())
              )      
           ),
      group(
           "_id:0",
           avg("average", "$value"),
           sum("sum", "$value"),
           max("max", "$value"),
           min("min", "$value"),
           sum("count", 1)             
      )           
   )            
).into(new ArrayList<>());