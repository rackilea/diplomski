DBCollection mycoll= db.getCollection("domain");

    DBObject fields = new BasicDBObject("domain", 1);
    DBObject project = new BasicDBObject("$project", fields );

    // Now the $group operation
    DBObject groupFields = new BasicDBObject( "_id", "$domain");
    groupFields.put("total", new BasicDBObject( "$sum", 1));
    DBObject group = new BasicDBObject("$group", groupFields);

    // run aggregation
    AggregationOutput output = mycoll.aggregate(project, group);
    System.out.println(output.getCommand().toString());

    for (DBObject dbObject : output.results()) {
        System.out.println(dbObject);
    }