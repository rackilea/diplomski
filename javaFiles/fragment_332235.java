DObject query = new BasicDBObject("country", 
    new BasicDBObject( "$elemMatch", new BasicDBObject(
        "code", "US").put( "value", new BasicDBObject( "$gt", 4 ) 
    )
);

query.put( "state": new BasicDBObject( "$size", 1 ) );