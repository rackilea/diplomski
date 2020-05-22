DBCollection coll = db.getCollection("privateMessages")

    query = new BasicDBObject();

    query.put("sendingUser.userID", new BasicDBObject("$eq", 34345)); 

    cur = coll.find(query); // all documents with  sendingUser.userID = 34345 will be //returned by cursor