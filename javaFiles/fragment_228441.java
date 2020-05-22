import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static java.util.Arrays.asList;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import org.bson.conversions.Bson;

MongoCollection<Document> mongoEngCollection = mongoDbReader.getCollection();

List<Bson> obj = new ArrayList<>();
//Forming query using request parameter. requestAttributes contains map of request parameters.
for(Map.Entry<PathAttribute, PathValue<?>> entry : requestAttributes.entrySet()) {
   String key = entry.getKey().getName();
   //Check if key is not date and set the start and end date
   obj.add(eq(key, entry.getValue().getRawValue()));
}

//Build aggregation stages
Bson match = match(and(obj));
Bson group = group(
              first("user", "$name"), 
              sum("total_results", 1), 
              push("results", "$$ROOT")
);
Bson projection = project(fields(excludeId()));

//Query Mongodb
List<Document> results = mongoEngCollection .aggregate(asList(match, group, projection)).into(new ArrayList<Document>());