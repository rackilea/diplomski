List<Document> pipeline = Arrays.asList(
  new Document("$project",
    new Document("data1", 1)
      .append("result", new Document(
        "$cond", Arrays.asList(
          new Document("$eq", Arrays.asList("$salary", 250000) ),
          30,
          20
        )
      ))
  )
);