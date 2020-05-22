public <T> void saveObj(T obj){
        String dbName = "New";
        MongoDatabase database = getMongoDatabase(dbName);
        MongoCollection<T> collection = (MongoCollection<T>) database.getCollection(obj.getClass().getSimpleName(), obj.getClass());
        collection.insertOne(obj);
    }

    public MongoDatabase getMongoDatabase(String dbName) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientURI connectionString = new MongoClientURI("my-mongo-string");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase(dbName);
        database = database.withCodecRegistry(pojoCodecRegistry);
        return database;
    }