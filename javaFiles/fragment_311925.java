public HashMap<String, String> fetchData() {

    // Collection that stores appName and apiKey
    MongoCollection<Document> collection = db.getCollection("info");

    HashMap<String, String> appKeys = new HashMap<String, String>();

    // Getting the list of appName and appKey from info DB
    AggregateIterable<Document> output = collection
            .aggregate(Arrays.asList(new BasicDBObject("$group", new BasicDBObject("_id",
                    new BasicDBObject("_id", "$id").append("appName", "$appName").append("appKey", "$appKey"))

    )));

    String appName = null;
    String appKey = null;

    for (Document doc : output) {

        Document temp = (Document) doc.get("_id");

        appName = (String) temp.get("appName");
        appKey = (String) temp.get("appKey");
        appKeys.put(appName, appKey);

    }
    return appKeys;