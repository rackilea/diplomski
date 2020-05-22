BasicDBObject query = new BasicDBObject(
        "_id", new ObjectId("5396ad5de4b09ea27a641ed6")
    );
    BasicDBObject update = new BasicDBObject(
        "$set", new BasicDBObject("doc_occurance.total", 30)
    );

    table.update(query,update);