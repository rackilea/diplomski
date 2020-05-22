Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
    eav.put(":v1", new AttributeValue().withS(testName));
    eav.put(":v2", new AttributeValue().withS(version));
    eav.put(":v3", new AttributeValue().withN(String.valueOf(minRev)));
    eav.put(":v4", new AttributeValue().withN(String.valueOf(maxRev)));

    final DynamoDBQueryExpression<ValidationReport> query = new DynamoDBQueryExpression<>();
    query.withKeyConditionExpression("testName = :v1");
    query.withFilterExpression("buildVersion = :v2 and revision BETWEEN :v3 AND :v4");
    query.setConsistentRead(false);
    query.withExpressionAttributeValues(eav);
    return getMapper().query(ValidationReport.class, query);`