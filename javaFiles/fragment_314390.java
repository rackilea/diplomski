DBObject operation = (DBObject) new BasicDBObject(
    "$group", BasicDBObjectBuilder.start(
        "_id", new BasicDBObject(
            "$ifNull", new String[]{"$vid", "$_id"}
        )
    )
    .append("vid", new BasicDBObject("$push", "$$ROOT"))
    .get()              
);