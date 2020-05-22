MongoCollection<Document> collection = database.getCollection("dictionary");

String word = "gambia";

DBObject query = new BasicDBObject("data." + word, new BasicDBObject(
            "$exists", true));

Document myDoc = collection.find(query);
System.out.println(myDoc);