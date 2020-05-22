MoDBIA_DAO dao = new MoDBIA_DAO(mongo, morphia, DB_Name);
Datastore dataStore = morphia.createDatastore(mongo, DB_Name);
Query<MoDBIAGlobals> query = dataStore.createQuery(MoDBIAGlobals.class).disableValidation();

query.field("data.FACEBOOK.channelId").equal("FB1234");
query.field("id").equal("user1234");

QueryResults<MoDBIAGlobals> results = dao.find(query);
System.out.println("results: " + results);
System.out.println("results.count: " + results.countAll());