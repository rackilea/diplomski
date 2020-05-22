public class JavaAggregation {
    public static void main(String args[]) throws UnknownHostException {

        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("test");

        DBCollection coll = db.getCollection("mycollection");

        // 1. Check for documents which have curFlag true
        DBObject match = new BasicDBObject("$match",
                            new BasicDBObject("curFlag", true)
                        );

        // 2. GroupBy owner and display the number of files per user
        DBObject groupFields = new BasicDBObject( "_id", "$meta.owner");
        groupFields.put("count", new BasicDBObject( "$sum", 1));
        DBObject group = new BasicDBObject("$group", groupFields);

        // 3. Display the user who is handling large no. of files
        DBObject sort = new BasicDBObject("$sort", 
                            new BasicDBObject("count", -1)
                        );
        DbObject limit = new BasicDBObject("$limit", 1);

        List<DBObject> pipeline = Arrays.asList(match, group, sort, limit);

        AggregationOutput output = coll.aggregate(pipeline);

        for (DBObject result : output.results()) {
            System.out.println(result);
        }
    }
}