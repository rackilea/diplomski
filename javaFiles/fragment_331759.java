public List<String> queryMoviesAndFilterByMapAttribute() {

    List<String> moviesJsonList = new ArrayList<>();

    DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);

    Table table = dynamoDB.getTable("Movies");

    QuerySpec querySpec = new QuerySpec();

    querySpec.withKeyConditionExpression("yearkey = :yearval and title = :titleval")
            //.withProjectionExpression("records.K1, records.K2")
            .withFilterExpression("records.K1 = :recordsK1Value and records.K2 = :recordsK2Value").withValueMap(
                    new ValueMap().withNumber(":yearval", 1991).withString(":titleval", "Movie with map attribute")
                            .withString(":recordsK1Value", "V1").withString(":recordsK2Value", "V2"));

    IteratorSupport<Item, QueryOutcome> iterator = table.query(querySpec).iterator();

    while (iterator.hasNext()) {
        Item movieItem = iterator.next();
        System.out.println("Movie data ====================>" + movieItem.toJSONPretty());
        moviesJsonList.add(movieItem.toJSON());
    }

    return moviesJsonList;

}