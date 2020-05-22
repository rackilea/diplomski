public static DB getMongoDB() {

        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        //build the connection options  
        builder.maxConnectionIdleTime(60000);//set the max wait time in (ms)
        MongoClientOptions opts = builder.build();


        char[] password2 = "mypassword".toCharArray();

        MongoCredential credential2 = MongoCredential.createCredential("username", "databasename",password2);


        //add your option to the connection 

        MongoClient mongoClient = new MongoClient(new ServerAddress("server ip",27017), Arrays.asList(credential2),opts);
        //use your database 
        cachedDb = mongoClient.getDB("databasename");

    return cachedDb;

}