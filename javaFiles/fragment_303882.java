DBCollection coll = db.getCollection("test");
BasicDBObject query = new BasicDBObject("room", "Kitchen"); 

// optional, limit the fields to only have the lights field
BasicDBObject fields = new BasicDBObject("lights",1).append("_id",false);
DBCursor curs = coll.find(query, fields);
while(curs.hasNext()) {
  DBObject o = curs.next();

  // shows the whole result document
  System.out.println(o.toString());
  BasicDBList lights = (BasicDBList) o.get("lights");

  // shows the lights array -- this is actually a collection of DBObjects
  System.out.println(lights.toString());

  // optional: break it into a native java array
  BasicDBObject[] lightArr = lights.toArray(new BasicDBObject[0]);
  for(BasicDBObject dbObj : lightArr) {
    // shows each item from the lights array
    System.out.println(dbObj);
  }
}