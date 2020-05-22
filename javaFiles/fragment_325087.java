DBObject findCommand = new BasicDBObject(
    "$text", new BasicDBObject("$search", "keyword")
);

DBObject projectCommand =  new BasicDBObject(
    "score", new BasicDBObject("$meta", "textScore"));

DBObject sortCommand = new BasicDBObject(
    "score", new BasicDBObject("$meta", "textScore")
);
DBCursor result = collection.find(
                                  findCommand ,projectCommand)
                                  .sort(sortCommand );