MongoCollection<Document> collection = db.getCollection("collection");
List<WriteModel<Document>> writes = Arrays.<WriteModel<Document>>asList(
    new ReplaceOneModel<Document>(
        new Document("_id", 1001), // filter
        new Document("author", "newName"), // update
        new UpdateOptions().upsert(true) // options
    )   
);

BulkWriteResult bulkWriteResult = collection.bulkWrite(writes);