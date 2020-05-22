Aggregation aggregation = newAggregation(
    new CutomAggregationOperation(
        new BasicDBObject(
            "$sample",
            new BasicDBObject( "size", 15 )
        )
    )
);