Table table = dynamoDB.getTable("Movies");

    QuerySpec querySpec = new QuerySpec();

    querySpec.withKeyConditionExpression("yearkey = :yearval")
            .withValueMap(
                    new ValueMap().withNumber(":yearval", yearkey))
            .withScanIndexForward(false);

    IteratorSupport<Item, QueryOutcome> iterator = table.query(querySpec).iterator();

    while (iterator.hasNext()) {
        Item movieItem = iterator.next();
        System.out.println("Movie data ====================>" + movieItem.toJSONPretty());
        moviesJsonList.add(movieItem.toJSON());
    }