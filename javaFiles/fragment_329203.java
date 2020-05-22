DBObject operation = (DBObject)new BasicDBObject(
    "$group", new BasicDBObject(
        "_id", "$bid"
    )
    .append( "nb", new BasicDBObject("$sum", 1) )
    .append(
        "nbS", new BasicDBObject(
            "$sum", new BasicDBObject(
                "$cond", new Object[]{ "$scst", 1, 0 }
            )
        )
    ).append(
        "nbE", new BasicDBObject(
            "$sum", new BasicDBObject(
                "$cond", new Object[]{ "$scst", 0, 1 }
            )
        )
    )
);