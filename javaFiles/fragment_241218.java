Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(c),
            new CustomGroupOperation(
                new BasicDBObject("$group",
                    new BasicDBObject("_id",
                        new BasicDBObject("programa","$programa")
                            .append("dataHora",
                                new BasicDBObject("$add",Arrays.asList(
                                    new BasicDBObject("$subtract",Arrays.asList(
                                        new BasicDBObject("$subtract",Arrays.asList(
                                            new BasicDBObject("$subtract",Arrays.asList(
                                                "$dataHora", new Date(0)
                                            )),
                                            25200000
                                        )),
                                        new BasicDBObject("$mod",Arrays.asList(
                                            new BasicDBObject("$subtract",Arrays.asList(
                                                new BasicDBObject("$subtract",Arrays.asList(
                                                    "$dataHora", new Date(0)
                                                )),
                                                25200000
                                            )),
                                            1000 * 60 * 60 * 24
                                        ))
                                    )),
                                    new Date(0)
                                ))
                            )
                    )
                    .append("count",new BasicDBObject("$sum",1))
                    .append("valorTotal",new BasicDBObject("$sum","$custo"))
                    .append("duracaoTotal",new BasicDBObject("$sum","$duracao"))
                    .append("dataHora",new BasicDBObject("$first","$dataHora"))
                )
            ),
            Aggregation.sort(Direction.ASC,"_id.dataHora")
    );