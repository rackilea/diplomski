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
    def dbObjArray = new BasicDBObject[1]
    dbObjArray[0]= match
    List<DBObject> flatPipeline = Arrays.asList(dbObjArray)

    AggregationOptions aggregationOptions = AggregationOptions.builder()
                                    .batchSize(100)
                                    .outputMode(AggregationOptions.OutputMode.CURSOR)
                                    .allowDiskUse(true)
                                    .build();
    def cursor = dataSetCollection.aggregate(flatPipeline,aggregationOptions)
    try {
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    } 
    finally {
        cursor.close();
    }
}