import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Starter {

    private static MongoClient mongoClient;

    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.trustStore", "mongodb.pkcs12");
        System.setProperty("javax.net.ssl.trustStorePassword", "yourPassword");
        System.setProperty("javax.net.ssl.keyStore", "mongodb.pkcs12");
        System.setProperty("javax.net.ssl.keyStorePassword", "yourPassword");

        MongoClientURI mongoClientURI = new MongoClientURI(
                "mongodb://admin:admin@hostname3.xyz.com,hostname2.xyz.com:27017,hostname3.xyz.com:27017/admin?ssl=true");
        mongoClient = new MongoClient(mongoClientURI);

        try {
            MongoDatabase db = mongoClient.getDatabase("CIM");
            MongoCollection<Document> collection = db.getCollection("orders");
            System.out.println("No of Documents in orders collection: "
                    + collection.count());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}