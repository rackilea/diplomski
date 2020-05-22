UpdateItemRequest request = new UpdateItemRequest();
request.setTableName("myTableName");
request.setKey(Collections.singletonMap("hashkey", 
    new AttributeValue().withS("my_key")));
request.setUpdateExpression("list_append(:prepend_value, my_list)");
request.setExpressionAttributeValues(
    Collections.singletonMap(":prepend_value", 
        new AttributeValue().withN("1"))
    );
dynamodb.updateItem(request);`