package kelas_java;
public class searchingDariSemuaKolom {

    static void doPrint(String keys, Object value, DB db, String collectionName) {
        BasicDBList or = new BasicDBList();
        for (String key : keys) {
            or.add(new BasicDBObject(key, value));
        }
        DBObject query = new BasicDBObject("$or", or);
        DBCollection table = db.getCollection(collectionName);

        try {
            DBCursor cur = table.find(query);
            while (cur.hasNext()) {
                System.out.println(cur.next().get("title"));
            }
        } catch (MongoException e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            cur.close();
        }
    }
    public static void main(String[] args) {
        BasicDBObject sortOrder = new BasicDBObject();
        MongoClient mongoClient;
        DB db;

        String strs[] = {
            "link", 
            "title",
            "body", 
            "date", 
        };
        try {
            mongoClient = new MongoClient("localhost", 27017);
            db = mongoClient.getDB("face");
            boolean auth = db.authenticate("aku", "kamu".toCharArray());
            Pattern regex = Pattern.compile("1");

            //start1
            doPrint(keys , regex , db , "titles");
            //start2
            doPrint(keys , regex , db , "news");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}