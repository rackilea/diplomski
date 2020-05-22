import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

public class Mongo {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        MongoDatabase db = mongoClient.getDatabase("dbName");

        MongoCollection <org.bson.Document> dbCollection = db.getCollection("collectionName", org.bson.Document.class);

        MongoCursor <org.bson.Document> iterator = dbCollection.find().iterator();

        while (iterator.hasNext()) {
            org.bson.Document inDoc = iterator.next();
            Document outDoc = new Document();
            outDoc.setId(inDoc.getObjectId("_id"));
            outDoc.setName(inDoc.getString("name"));
            System.out.print(outDoc.toString());
        }

    }


    public static class Document {

        private ObjectId id;
        private String name;

        public ObjectId getId() {
            return id;
        }

        public void setId(ObjectId id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
        }

    }
}