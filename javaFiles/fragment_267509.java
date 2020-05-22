Builder hour = new Builder();
    hour.add(Expressions.set("day",Expressions.hour(Expressions.field("date"))));
    Aggregate.Builder builder = Aggregate.builder();
    builder.group(
       hour,
       AggregationGroupField.set("pop").sum("pop")
      );
    MongoIterator<Document> result = col.aggregate(builder);
    while(result.hasNext())
    {
        System.out.println(result.next());
    };