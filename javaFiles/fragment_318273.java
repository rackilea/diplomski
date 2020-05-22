FindIterable<Document> iterable = mongoDatabase.getCollection("employee").find(
            new Document("empid", 1));
    iterable.forEach(new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.get("address").toString());
        }
    });