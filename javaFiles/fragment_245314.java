Iterator<Document> it = mongoClient.getDatabase("database1")
                       .getCollection("users")
                       .aggregate(Arrays.asList(
                            new Document("$match", new Document("lastlogin", 
                                new Document("$gte", subtracted).append("$lte", now))
                            ),
                            new Document("$group", new Document("_id", null)
                                .append("count", 
                                    new Document("$sum", 1)
                                )
                            )
                        )
                    ).iterator();
int count = it.hasNext() ? (Integer)it.next().get("count") : 0;