List<Document> docs = new ArrayList<>();

BasicDBObject filter = new BasicDBObject();
filter.put("publishedDateTime", new Document("$gte", LocalDate.of(2019, 02, 25));
// Do not forget to send the filter to the query!
for(Document doc:collection.find(filter)) {
   docs.add(doc);
}