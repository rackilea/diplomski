MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase db = mongoClient.getDatabase("behaviourDB_areas");
    MongoCollection cEvent = db.getCollection("event", Document.class);

    MongoCursor<Document> cursorEvents = cEvent
            .find(new BasicDBObject("user_id", "55b20db905f333defea9827f"))
            .sort(new BasicDBObject("timeStamp",1))
            .iterator();

    int count = 0;

    if(cursorEvents.hasNext()) {
        Document doc = cursorEvents.next();
        System.out.println(doc.getString("type"));
        if (doc.containsKey("url")) {
            System.out.println(doc.getString("url"));
        }
        System.out.println(++count);
    }

    cursorEvents.close();
    mongoClient.close();