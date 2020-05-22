import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class GetDataFromMongodbUsingElemMatch {
    public static void main(String[] args) {

        MongoClient client = new MongoClient();

        MongoDatabase database = client.getDatabase("localhost");

        MongoCollection<Document> userCollection = database.getCollection("users");

        FindIterable<Document> users = userCollection.find(Filters.elemMatch("assignedMember",
                Filters.and(Filters.eq("userId", "54782bfce4b086cb31d51dd5"), Filters.eq("status", "ASSIGNED"))));

        for (Document user : users) {
            System.out.println(user.toJson());
        }

        client.close();

    }

}