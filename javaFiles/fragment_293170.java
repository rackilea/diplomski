DBCollection coll = db.getCollection("myObject");
        DBObject query = new BasicDBObject("myId", "A String ID that i created");

        DBObject listItem = new BasicDBObject();
        listItem.put("myString", "my new string");
        listItem.put("myInteger", 9003);

        DBObject updateObj = new BasicDBObject("myList", listItem);

        coll.update(query, new BasicDBObject("$push", updateObj));