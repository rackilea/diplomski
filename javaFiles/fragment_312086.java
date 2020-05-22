MongoClient mongoClient = ...;

MongoCollection<Document> collection = mongoClient.getDatabase("...").getCollection("...");

List<Document> documents = collection.aggregate(Arrays.asList(
        Aggregates.unwind("$connects"),
        new Document("$group", new Document("_id", new Document("skill", "$skill").append("parser_id", "$connects.parser_id"))
                .append("count", new Document("$sum", 1))),
        new Document("$group", new Document("_id", "$_id.skill").append("quantity", new Document("$sum", 1))),
        new Document("$project", new Document("skill", "$_id").append("quantity", 1).append("_id", 0))
)).into(new ArrayList<>());

for (Document document : documents) {
    logger.info("{}", document.toJson());
}