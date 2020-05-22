ArrayList orList = new ArrayList();
ArrayList andList = new ArrayList();

orList.add(new BasicDBObject("text", "hi"));                  
orList.add(new BasicDBObject("username", "hi"));

andList.add(new BasicDBObject("gender", "male"));
andList.add(new BasicDBObject("place", "pune"));
andList.add(new BasicDBObject("$and", orList));

BasicDBObject query = new BasicDBObject("$or", andList);