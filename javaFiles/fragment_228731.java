import org.bson.Document;

MongoDatabase database = mongoClient.getDatabase("test");
    MongoCollection<Document> collection = database.getCollection("test");
    MongoCursor<Document> cursor = collection.find().iterator();
    try {
       while(cursor.hasNext()) {
           System.out.println(cursor.next().toJson());
       }
    } finally {
       cursor.close();
    }