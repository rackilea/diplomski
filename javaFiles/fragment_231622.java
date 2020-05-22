import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Projections.*;
import static java.util.Arrays.asList;

Bson match = Aggregates.match(Filters.eq("ID_STATUSMATRICULA", 1));
Bson group = group(null,
                avg("MEDIA_APROVADOS", 
                computed("$cond", 
                         asList(new Document("$eq", asList("$ID_STATUSAPROVEITAMENTO", 1)), 
                        "$NR_APROVEITAMENTO", 0))
                 )
           );
collection.aggregate(asList(match, group));