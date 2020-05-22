DBObject query = new BasicDBObject("_id", "123"); 
DBObject update = new BasicDBObject(); 
DBObject info = new BasicDBObject("test","test1");
update.put("$set", new BasicDBObject("data.2",
new BasicDBObject("info",info).append("info1",info)); 

collection.update(query, update);