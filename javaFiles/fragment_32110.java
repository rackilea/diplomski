MongoClient mongoClient = ...;

MongoCollection<Document> collection = mongoClient.getDatabase("...")
    .getCollection("...");

Bson filter = Filters.eq("eventDetails.stateCode", "Y-FINISH");

long count = collection.count(filter);