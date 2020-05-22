BasicDBObject query = new BasicDBObject();
query.put("country", "New Zealand");
query.append("regions.region", "Waikato");

BasicDBObject update = new BasicDBObject()
    .append("$inc", new BasicDBObject().append("regions.$.size", 145));

collection.update(query, update, true, false);