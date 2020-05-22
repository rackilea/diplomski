MongoClient mongoClient = new MongoClient();
 MongoDatabase db = mongoClient.getDatabase("test");
 MongoCollection col = db.getCollection("input");

 Input input = new Input();
 input.setName("name");
 input.setDate(new Date());

 Document doc = new Document();
 doc.append("name", input.getName());
 doc.append("date", input.getDate())

 col.insertOne(doc);