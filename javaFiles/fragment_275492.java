List<Document> aggregates = Arrays.asList(
        new Document("$match", new Document("_id", new ObjectId("5d55ac30e533bc76e4581923"))),
        new Document("$lookup", new Document("from", "employee")
        .append("localField", "leads")
        .append("foreignField", "_id")
        .append("as", "leads")));

AggregateIterable<Document> iterable = collection.aggregate(aggregates);

for (Document row : iterable) {
    System.out.println(row.toJson());
}