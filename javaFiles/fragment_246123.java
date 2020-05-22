DBCollection colllection = mongoTemplate.getCollection("collectionName");

    List<DBObject> pipeline = Arrays.<DBObject>asList(
        new BasicDBObject("$match",new BasicDBObject("dataset","d1")),
        new BasicDBObject("$group",
            new BasicDBObject("_id","$source")
                .append("name",new BasicDBObject("$first","$name"))
                .append("description", new BasicDBObject("$first","$description"))
        )
    );

    AggregationOutput output = colllection.aggregate(pipeline);