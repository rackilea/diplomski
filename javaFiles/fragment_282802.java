List<Document> pipeline = Arrays.asList(
  new Document("$project",
    new Document("data1", 1)
      .append("result", new Document(
        "$cond", new Document(
          "if", new Document("$eq", Arrays.asList("$salary", 250000) )
        )
        .append("then", 30)
        .append("else", 20) 
      ))
  )
);