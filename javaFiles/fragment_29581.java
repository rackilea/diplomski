CreateTableRequest createTableRequest = new CreateTableRequest()
                .withTableName("testtable")
                .withKeySchema(
                        new KeySchemaElement("id", KeyType.HASH)
                )
                .withProvisionedThroughput(new ProvisionedThroughput(1L, 1L))
                .withAttributeDefinitions(
                        new AttributeDefinition("id", "S")
                );

        CreateTableResult result = amazonDynamoDB.createTable(createTableRequest);