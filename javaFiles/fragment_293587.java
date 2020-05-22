MongoClient mongoClient = new MongoClient();
 MongoDatabase db = mongoClient.getDatabase("db");
 MongoCollection<Document> collection = db.getCollection("collection");
 Bson aggregates = Aggregates.project(Projections.fields(Projections.include("dt", "mc", "uplift","baseAvg"),
               new Document("baseUp", new Document("$add", Arrays.<Object>asList("$uplift", "$baseAvg"))),
               new Document("share", new Document("$cond", Arrays.<Object>asList(new Document("$eq", Arrays.<Object>asList("$baseAvg", 0)),
                                        0, new Document("$divide",  Arrays.<Object>asList("$uplift", "$baseAvg")))))));
 List<Document> results = collection.aggregate(Arrays.asList(aggregates)).into(new ArrayList<>());