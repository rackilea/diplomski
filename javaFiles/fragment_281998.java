public class JavaAggregation {
    public static void main(String args[]) throws UnknownHostException {

        MongoClient mongo = new MongoClient();
        DB db = mongo.getDB("databaseName");

        DBCollection coll = db.getCollection("dataset");

        /*
            MONGO SHELL : 
            db.dataset.aggregate([ 
                { "$match": { isFlat : true } }, 
                { "$out": "datasetTemp" }
            ])
        */

        DBObject match = new BasicDBObject("$match", new BasicDBObject("isFlat", true)); 
        DBObject out = new BasicDBObject("$out", "datasetTemp"); 

        AggregationOutput output = coll.aggregate(match, out);

        DBCollection tempColl = db.getCollection("datasetTemp");
        DBCursor cursor = tempColl.find();

        try {
            while(cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }
}