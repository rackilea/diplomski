Map<String, AttributeValue> expValues = new HashMap<>();
 expValues.put(":hv", new AttributeValue("PFS"));
 expValues.put(":osv", new AttributeValue("PO"));
 expValues.put(":etav", new AttributeValue("2017-01-01"));

 QueryRequest q = new QueryRequest("OrderDashboardMetadata");
 q.setKeyConditionExpression("queueName = :hv");
 q.setFilterExpression("orderState = :osv and ETA > :etav");
 q.setExpressionAttributeValues(expValues);
 QueryResult r = dbClient.query(q);