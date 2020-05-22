AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();

// In all cases, setting null tells DynamoDBMapper to use the default value 
DynamoDBMapperConfig mapperConfig = new DynamoDBMapperConfig(
    null, // Save behavior
    null, //ConsistentReads
    “TableName”, //TableNameOverride
    null // PaginationLoadingStrategy
);

DynamoDBMapper mapper = new DynamoDBMapper(client, mapperConfig, cp);