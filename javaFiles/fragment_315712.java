private AmazonDynamoDB amazonDynamoDB;

@Before
public void setup() throws Exception {

    amazonDynamoDB =  DynamoDBEmbedded.create().amazonDynamoDB();//dynamoDB.getAmazonDynamoDB();
    amazonDynamoDB.createTable(new CreateTableRequest()
            .withTableName(TABLE_NAME)
            .withKeySchema(new KeySchemaElement().withAttributeName(ITEM).withKeyType(KeyType.HASH))
            .withAttributeDefinitions(
                    new AttributeDefinition().withAttributeName(ITEM).withAttributeType(ScalarAttributeType.S))
            .withProvisionedThroughput(new ProvisionedThroughput(10L, 15L))
    );
}