@FunctionName("doc")
@DocumentDBOutput(name = "testdoc",
            createIfNotExists = true,
            databaseName = "db",
            collectionName="coll",
            connection = "CosmosDBConnectionString")
public String functionHandler(
            @TimerTrigger(name = "timerInfo", schedule = "*/30 * * * * *")
                    String timerInfo,
            final ExecutionContext executionContext) {

        String randomString=UUID.randomUUID().toString();
        executionContext.getLogger().info("Insert obj documentDB: " + randomString);
        Document document=new Document();
        document.set("id",randomString);
        document.set("name","Jay!!!");
        return document.toString();
    }