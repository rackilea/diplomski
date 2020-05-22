DBObject allQuery = new BasicDBObject();
DBObject removeIdProjection = new basicDBObject("_id", 0);

DBCollection collection = db.getCollection("volume");
DBCursor cursor = collection.find(allQuery, removeIdProjection);
DBObject resultElement = cursor.next();
Map resultElementMap = resultElement.toMap();
System.out.println(resultElementMap);