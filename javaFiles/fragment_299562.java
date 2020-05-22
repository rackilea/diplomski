Mongo client = new Mongo("127.0.0.1");

    DBCollection col = client.getDB("ajs").getCollection("items");

    AggregationOutput agout = col.aggregate(
           new BasicDBObject("$group",
                   new BasicDBObject("_id", "$name").append("value", new BasicDBObject("$push", "$value"))));

    Iterator<DBObject> results = agout.results().iterator();


   while(results.hasNext()) {
     DBObject obj = results.next();

     System.out.println(obj.get("_id")+" "+obj.get("value"));

  }