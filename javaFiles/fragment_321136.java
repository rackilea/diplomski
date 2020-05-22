import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.*;
import static java.util.Arrays.asList;

Bson match = match(eq("myKey", value));
Bson sample = sample(size);
collection.aggregate(asList(match, sample));