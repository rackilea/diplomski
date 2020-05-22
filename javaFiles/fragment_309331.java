public enum MongoDBHelper { // the best way to implement singletons, due to the author of Effective Java  
INSTANCE;

private DB db;
private Datastore datastore;

private final String SERVER_URL = "...";
private final int SERVER_PORT = ...;
private final String USERNAME= "...";
private final String PASSWORD = "...";
private final String DATABASE_NAME = "...";

private MongoDBHelper() {

    try {

        MongoClient mongoClient = new MongoClient(SERVER_URL, SERVER_PORT);

        this.db = mongoClient.getDB(DATABASE_NAME);
        this.db.authenticate(USERNAME,PASSWORD.toCharArray());

        Morphia morphia = new Morphia();

        this.datastore = morphia.createDatastore(mongoClient, DATABASE_NAME);

        morphia.mapPackage("package");
    } catch (UnknownHostException e) {
        e.printStackTrace();
    }

}

public DB getDB() {
    return this.db;
}

public Datastore getDatastore() {
    return this.datastore;
}
}