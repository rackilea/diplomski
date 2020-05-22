List<DBObject> pipeline = Arrays.<DBObject>asList(
        new BasicDBObject(
            "$match",
            new BasicDBObject(
                "contribs.0", new BasicDBObject("$exists",true)
            )
        ),
        new BasicDBObject(
            "$project",
            new BasicDBObject(
                "contribs", new BasicDBObject("$arrayElemAt", Arrays.asList("$contribs",0))
            )
        )
    );

    AggregationOutput output = this.coll.aggrgate(pipeline);