import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.Sorts.*;
import static java.util.Arrays.*;
List<Document> results = collectionName.aggregate(
     asList(
          match(in("_id",tempList)),
          unwind("$bal"),
          sort(descending("bal.date")),
          group("$_id", push("bal","$bal")),
          project(new Document("bal",new Document ("$slice", asList("$bal", 2))))
    )
).into(new ArrayList<>());