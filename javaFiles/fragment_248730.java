MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("localhost");
        MongoCollection<Document> normalUserCollection = database.getCollection("normaluser");

        User normalUser = new NormalUser("jack", "mike", "US", "dni", "123", Gender.MALE);

        Document document = new Document();
        document.put("user", document.parse(new ObjectMapper().writeValueAsString(normalUser)));