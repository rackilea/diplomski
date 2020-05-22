String json = "{'type':'exam','student_id':0}";
    DBObject dbObj = (DBObject) JSON.parse(json);
    DBObject projection = (DBObject) JSON.parse("{'score':1,}");
    System.out.println(dbObj);
    Dao dao = new Dao();
    final DBCollection collection = dao.getDb("test").getCollection("test");
    **List<DBObject> dbOList=collection.find(dbObj,projection).toArray();**
    System.out.println(dbOList);