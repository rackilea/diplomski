private static final String account = "***";
private static final String key = "***";

private static DocumentClient client = new DocumentClient("***",
        key, ConnectionPolicy.GetDefault(),
        ConsistencyLevel.Session);

@FunctionName("doc")
public String functionHandler(
        @TimerTrigger(name = "timerInfo", schedule = "*/5 * * * * *")
                String timerInfo,
        final ExecutionContext executionContext) {

    try {
        String randomString = UUID.randomUUID().toString();
        executionContext.getLogger().info("Insert obj documentDB: " + randomString);
        Document document = new Document();
        document.set("id", randomString);
        document.set("name", "Jay!!!");
        client.createDocument("dbs/db/colls/coll",document,null,false);
        return "Insert Success id: "+ randomString;
    } catch (Exception e) {
        executionContext.getLogger().info(e.toString());
        return e.toString();
    }

}