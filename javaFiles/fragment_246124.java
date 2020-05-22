DBCollection colllection = mongoTemplate.getCollection("collectionName");

    List<DBObject> pipeline = Arrays.<DBObject>asList(
        new BasicDBObject("$match",new BasicDBObject("dataset","d1")),
        new BasicDBObject("$group",
            new BasicDBObject("_id",
                new BasicDBObject("source","$source")
                    .append("name","$name")
                    .append("description","$description")
            )
        )
    );

    AggregationOutput output = colllection.aggregate(pipeline);