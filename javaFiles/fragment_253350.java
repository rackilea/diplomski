MongoCollection<Document> collection = db.getCollection("persons1");

    List li = new ArrayList();

    li.add("Sims");
    li.add("User2");

    List<WriteModel<Document>> updates = new ArrayList<WriteModel<Document>>();

    ListIterator listIterator = li.listIterator();

    while ( listIterator.hasNext() ) {
        updates.add(
            new UpdateOneModel<Document>(
                new Document("_id",listIterator.next()),
                new Document("$inc",new Document("count",1)),
                new UpdateOptions().upsert(true)
            )
        );
    }

    BulkWriteResult bulkWriteResult = collection.bulkWrite(updates);