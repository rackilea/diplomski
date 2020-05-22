BasicDBList list = new BasicDBList();
list.add(new BasicDBObject("a","aa"));
list.add(new BasicDBObject("b","bb"));

DBObject fieldTwo = new BasicDBObject("field2",list);

DBObject fieldOne = new BasicDBObject("field1",fieldTwo);