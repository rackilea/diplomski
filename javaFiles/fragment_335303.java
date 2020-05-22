Condition hashKeyCondition = new Condition();
hashKeyCondition.withComparisonOperator(ComparisonOperator.EQ).withAttributeValueList(new AttributeValue().withS(hashKeyAttributeValue));

Condition rangeKeyCondition = new Condition();
rangeKeyCondition.withComparisonOperator(ComparisonOperator.GT).withAttributeValueList(new AttributeValue().withN(timestamp.toString()));

Map<String, Condition> keyConditions = new HashMap<String, Condition>();
keyConditions.put(MappedItem.INDEXED_ATTRIBUTE_NAME, hashKeyCondition);
keyConditions.put(MappedItem.TIMESTAMP, rangeKeyCondition);


QueryRequest queryRequest = new QueryRequest();
queryRequest.withTableName(tableName);
queryRequest.withIndexName(MappedItem.INDEX_NAME);
queryRequest.withKeyConditions(keyConditions);

QueryResult result = amazonDynamoDBClient.query(queryRequest);

List<MappedItem> mappedItems = new ArrayList<MappedItem>();

for(Map<String, AttributeValue> item : result.getItems()) {
    MappedItem mappedItem = dynamoDBMapper.marshallIntoObject(MappedItem.class, item);
    mappedItems.add(mappedItem);
}

return mappedItems;