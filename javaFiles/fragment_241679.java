KTable<UserId, List<Reports>> result =
    builder.stream("topic-name")
           .groupByKey()
           // init a new empty list and
           // `add` the items to the list in the actual aggregation
           .aggregate(...);

result.to("result-topic");