MongoCursor<Document> iterator = collection.find()
    .modifiers(new Document("$explain",1)).iterator();

while (iterator.hasNext()) {
  System.out.println(iterator.next().toJson());
}