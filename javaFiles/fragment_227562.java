AggregateIterable<Document> iterable = collection.aggregate(Arrays.asList(
        new Document("$group", new Document("_id", "$id")
                .append("i", new Document("$sum", "$i"))
                .append("x", new Document("$sum", "$x"))
                .append("j", new Document("$sum", "$info.j"))
        ),
        new Document("$project",new Document("i",1)
                .append("x", new Document("x",1)),
                .append("x", new Document("info",
                   new Document("j", "$j")
                ))
        )
));