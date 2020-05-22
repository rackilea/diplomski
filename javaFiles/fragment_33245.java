MongoClient mongo = new MongoClient("localhost", 27017);
    DB db = (DB) mongo.getDB("testDB");
    DBCollection collection = db.getCollection("collection");
    DBObject query = new BasicDBObject("_id", "10-100-5675234");
    DBObject update = new BasicDBObject();
    update.put("$unset", new BasicDBObject("userId",""));
    WriteResult result = collection.update(query, update);
    mongo.close();