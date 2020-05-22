Map<String, String> attributeNames = new HashMap<String, String >();
attributeNames.put("#name", "name");
attributeNames.put("#date", "date");

Map<String, AttributeValue> attributeValues = new HashMap<String, AttributeValue>();
attributeValues.put(":var_date", new AttributeValue().withN(thirtyDaysAgo));
attributeValues.put(":var_name", new AttributeValue().withS("Unknown"));

ScanRequest scanRequest = new ScanRequest()
        .withTableName(TABLE_NAME)
        .withFilterExpression("#name <> :var_name AND #date > :var_date")
        .withExpressionAttributeNames(attributeNames)
        .withExpressionAttributeValues(attributeValues)