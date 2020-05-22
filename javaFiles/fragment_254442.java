MongoClient client = new MongoClient(new ServerAddress("192.168.2.4", 27017));

    MongoDatabase db = client.getDatabase("test");

    MongoCollection<Document> collection = db.getCollection("sample");

    MongoCursor<Document> iterator = collection.find().iterator();

    BasicDBList list = new BasicDBList();
    while (iterator.hasNext()) {
        Document doc = iterator.next();
        list.add(doc);
    }
    System.out.println(JSON.serialize(list));