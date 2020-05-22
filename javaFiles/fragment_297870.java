Aggregation aggregation = newAggregation(
    // custom pipeline stage
    new CutomAggregationOperation(
        new BasicDBObject(
            "$sample",
            new BasicDBObject( "size", 15 )
        )
    ),
    // Standard match pipeline stage
    match(
        Criteria.where("myDate")
            .gte(new Date(new Long("949384052490")))
            .lte(new Date(new Long("1448257684431")))
    )
);