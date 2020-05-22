BasicDBObject query = new BasicDBObject();
query.put("gender",new BasicDBObject("$type",2));
query.put("city",new BasicDBObject("$type",2));
query.put("phone",new BasicDBObject("$type",2));
query.put("email",new BasicDBObject("$type",2));
query.put("date",new BasicDBObject("$type",2));
query.put("age", new BasicDBObject("$type",1));

    DBCursor cursorDoc  =  collection.find(query);
    while (cursorDoc.hasNext()) {
        BasicDBObject object = (BasicDBObject) cursorDoc.next();
        System.out.println(object);
    }