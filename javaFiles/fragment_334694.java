Aggregation aggregation = newAggregation(
    new CustomGroupOperation(
        new BasicDBObject("$group",
            new BasicDBObject("_id",
                new BasicDBObject("year",new BasicDBObject("$year","$dateSold"))
                    .append("quarter",new BasicDBObject(
                        "$add",Arrays.asList(
                            new BasicDBObject("$subtract",Arrays.asList(
                                new BasicDBObject("$divide",Arrays.asList(
                                    new BasicDBObject("$subtract",Arrays.asList(
                                        new BasicDBObject("$month","$dateSold"),
                                        1
                                    )),
                                    3
                                )),
                                new BasicDBObject("$mod",Arrays.asList(
                                    new BasicDBObject("$divide", Arrays.asList(
                                        new BasicDBObject("$subtract",Arrays.asList(
                                            new BasicDBObject("$month", "$dateSold"),
                                            1
                                        )),
                                        3
                                    )),
                                    1
                                ))
                            )),
                            1
                        )
                    ))
            )
            .append("unitsSold", new BasicDBObject("$sum", "$unitsSold"))
        )
    )
);