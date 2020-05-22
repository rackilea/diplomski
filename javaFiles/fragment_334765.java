Query<Entity> query = Query.gqlQueryBuilder(Query.ResultType.ENTITY,             
                          "SELECT * FROM " + kind + " WHERE num < @num")
                      .setBinding("num", 100)
                      .build();
QueryResults<Entity> results = datastore.run(query);
while (results.hasNext()) {
    Entity result = results.next();
    myList.add(result.getString("num"));
...