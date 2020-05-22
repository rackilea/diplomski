// Java 8
List<Document> asList = new ArrayList<>();
documents.forEach((Consumer<Document>) d -> asList.add(d));

// Guava
List<Document> asList = Lists.newArrayList(documents);

// old skool
List<Document> asList = new ArrayList<>();
for (Document d : documents) {
    asList.add(d);
}