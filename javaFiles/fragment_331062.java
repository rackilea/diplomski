MongoClient client = new MongoClient(addr, opts);
MongoDatabase db = client.getDatabase(database);
try {
    MongoIterable<String> allCollections = db.listCollectionNames();
    for (String collection : allCollections) {
        System.out.println("MongoDB collection: " + collection);
    }
} catch (Exception me) {
    // problems with mongodb
}