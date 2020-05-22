BasicDBList myOr = new BasicDBList();
   myOr.add(new BasicDBObject("isDeleted", false));
   myOr.add(new BasicDBObject("isDeleted", new BasicDBObject("$exists", false)));


   DBObject query = new BasicDBObject("companyId",1)
       .append("$or", myOr);

   DBCursor myCursor = collection.find(query);