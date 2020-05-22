Aggregation aggregation = newAggregation(
            new CustomGroupOperation(
                    new BasicDBObject("$group",
                        new BasicDBObject("_id",
                            new BasicDBObject("status","$status")
                                .append("queue","$queueName")
                        )
                        .append("count",new BasicDBObject("$sum",1))
                        .append("oldest", new BasicDBObject("$min","$queueTime"))
                        .append("slow",
                            new BasicDBObject("$sum",
                                new BasicDBObject("$cond",Arrays.asList(
                                    new BasicDBObject("$lte",Arrays.asList(
                                        "$queueServiceTs",
                                        new Date()
                                    )),
                                    1,
                                    0
                                ))
                            )
                        )
                    )
            )
    );