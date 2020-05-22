MongoClient mongoClient = null;

    try {
        mongoClient = new MongoClient("localhost", 27017);
    } catch (UnknownHostException e) {}

    DB db = mongoClient.getDB("test");

    DBCollection collection = db.getCollection("user");

    DBObject match = new BasicDBObject("$match", new BasicDBObject("id", "11"));
    DBObject groupFields = new BasicDBObject("_id", "$name");
    groupFields.put("name", new BasicDBObject("$addToSet", "$name"));
    DBObject group = new BasicDBObject("$group", groupFields);

    AggregationOutput output = collection.aggregate(match, group);

    Iterable<DBObject> itResult = output.results();

    for (DBObject dbo : itResult) {
        List<String> items = (List<String>) dbo.get("name");
        for(String item : items){
            System.out.println(item);
        }

    }