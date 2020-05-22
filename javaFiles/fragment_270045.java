DynamoDataObject data = new DynamoDataObject();
data.setId(userId);

DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
    .withHashKeyValues(data)
    .withConsistentRead(false);

PaginatedList<DynamoDataObject > result = AWSProvider.getInstance().getDynamoDBMapper().query(DynamoDataObject.class, queryExpression);
Log.d(TAG, "PaginatedList length: " + result.size());