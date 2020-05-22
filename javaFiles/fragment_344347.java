DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
       Map expected = new HashMap();
       expected.put("Status", 
          new ExpectedAttributeValue(new AttributeValue(status)).withComparisonOperator(ComparisonOperator.NE));
saveExpression.setExpected(expected);
dynamoDBMapper.save(obj, saveExpression);