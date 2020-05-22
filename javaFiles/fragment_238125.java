final MongoClient mongoClient = new MongoClient();
    final DB db = mongoClient.getDB("DB_NAME");
    final DBCollection collection = db.getCollection("COLLECTION_NAME");

    final Map<String, Object> groupIdMap = new HashMap<String, Object>();
    groupIdMap.put("year", new BasicDBObject("$year", "$date"));
    groupIdMap.put("month", new BasicDBObject("$month", "$date"));
    groupIdMap.put("day", new BasicDBObject("$dayOfMonth", "$date"));

    final DBObject groupIdFields = new BasicDBObject("_id", new BasicDBObject(groupIdMap));

    groupIdFields.put("count", new BasicDBObject("$sum", 1));
    final DBObject group = new BasicDBObject("$group", groupIdFields);

    final DBObject projectFields = new BasicDBObject("_id", 0);
    projectFields.put("year", "$_id.year");
    projectFields.put("month", "$_id.month");
    projectFields.put("day", "$_id.day");
    projectFields.put("count", 1);
    final DBObject project = new BasicDBObject("$project", projectFields);

    final AggregationOutput aggregate = collection.aggregate(group, project);