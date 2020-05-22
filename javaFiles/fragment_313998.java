AmazonDynamoDB dynamoDBClient = createClient();
DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);        

String tableName = "student";
Table table = dynamoDB.getTable(tableName);

Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
expressionAttributeValues.put(":sc", schoolname);

ItemCollection<ScanOutcome> items = table.scan("school = :sc", // FilterExpression
    "sid, school, firstname, classname", // ProjectionExpression
    null, // ExpressionAttributeNames - not used in this example
    expressionAttributeValues);

Iterator<Item> iterator = items.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next().toJSONPretty());
}