MongoClient mongoClient = new MongoClient();
ObjectId objectId = ObjectId.get();
DB test1 = mongoClient.getDB("test1");
BasicDBObject dbObject = new BasicDBObject("_id",objectId)
.append("key", "value");
test1.getCollection("test").insert(dbObject);