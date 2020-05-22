DBCollection coll = mongoClient.getDB( "mydb" ).getCollection("mycoll");
    ArrayList<BasicDBObject> dbos = new ArrayList<BasicDBObject>();
    while(id>0){
        dbs.add(new BasicDBObject());
        id--;
    }
    coll.insert(dbos);