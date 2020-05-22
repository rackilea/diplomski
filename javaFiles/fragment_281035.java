DBCollection collection = mongoTemplate.getCollection("company");           
        DBObject query= new BasicDBObject("companyId","1");        
        DBObject update= new BasicDBObject(
            "$set", new BasicDBObject("phoneNumber","404-525-3928")
        );          
        DBObject result = collection.findAndModify(query, update);