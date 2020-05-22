MongoClient client = new MongoClient();
    List<String> continentList = Arrays.asList(new String[]{"Trivia"});
    DB db = client.getDB("example");
    DBCollection coll = db.getCollection("exp");
    DBObject matchFields = new 
       BasicDBObject("show.season.episodes.questionEntry.metaTags", 
      new BasicDBObject("$in", continentList));
    DBObject groupFields = new BasicDBObject( "_id",
       "$_id").append("episodes", 
       new BasicDBObject("$push","$show.season.episodes"));
    DBObject unwindshow = new BasicDBObject("$unwind","$show");
    DBObject unwindsea = new BasicDBObject("$unwind", "$show.season");
    DBObject unwindepi = new BasicDBObject("$unwind", 
      "$show.season.episodes");
    DBObject match = new BasicDBObject("$match", matchFields);
    DBObject group = new BasicDBObject("$group", groupFields);      
    AggregationOutput output = 
    coll.aggregate(unwindshow,unwindsea,unwindepi,match,group);

    for (DBObject result : output.results()) {
         System.out.println(result);
         }