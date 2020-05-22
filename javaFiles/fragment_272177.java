AWSCredentialsProvider provider = new InstanceProfileCredentialsProvider();

    AWSCredentials credential = provider.getCredentials();

    AmazonDynamoDBClient client = new AmazonDynamoDBClient(credential);

    client.setRegion(Region.getRegion(Regions.US_WEST_2));

    DynamoDB dynamoDB = new DynamoDB(client);

    TableCollection<ListTablesResult> tables = dynamoDB.listTables();