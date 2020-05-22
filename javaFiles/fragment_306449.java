MongoCollection<Document> collection = db.getCollection("characters");
List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();
writes.add(
    new InsertOneModel<Document>(
        new Document("_id", 4)
            .append("char", "Dithras")
            .append("class", "barbarian")
            .append("lvl", 3)
    )
);
writes.add(
    new InsertOneModel<Document>(
        new Document("_id", 5)
            .append("char", "Taeln")
            .append("class", "fighter")
            .append("lvl", 4)
    )
);
writes.add(
    new UpdateOneModel<Document>(
        new Document("char", "Eldon"), // filter
        new Document("$set", new Document("status", "Critical Injury")) // update
    )
);
writes.add(new DeleteOneModel<Document>(new Document("char", "Brisbane")));
writes.add(
    new ReplaceOneModel<Document>(
        new Document("char", "Meldane"), 
        new Document("char", "Tanys")
            .append("class", "oracle")
            .append("lvl", 4)           
    )
);

BulkWriteResult bulkWriteResult = collection.bulkWrite(writes);