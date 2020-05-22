MongoClient mongo = new MongoClient( "localhost" , 27017 );
DB db = mongo.getDB(dbName);
DBCollection collection = db.getCollection(collectionName);

BasicDBObject whereQuery = new BasicDBObject();
whereQuery.put("movie_id", id);

DBObject document = collection.findOne(whereQuery);
BasicDBList list = (BasicDBList) document.get("genre");

List<String> res = new ArrayList<String>();

for(Object el: list) {
     res.add((String) el);
}