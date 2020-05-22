while (cursor.hasNext()) {
  BasicDBObject obj = (BasicDBObject) cursor.next();
  BasicDBObject fieldOne = (BasicDBObject)(obj.get("field1"));

  // get the list
  BasicDBList field2List = (BasicDBList)(fieldOne.get("field2"));

  // add something to it
  field2List.add(new BasicDBObject("a","aa"));
  list.add(new BasicDBObject("b","bb"));
  list.add(new BasicDBObject("c","cc"));


  //save it
  this.dataColl.save(obj);
  }