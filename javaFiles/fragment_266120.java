public static void main(String[] args) {
    try {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("StackOverflow");
        DBCollection dbcol = db.getCollection("features");

        DBCursor cursor = dbcol.find();

        try {

            while (cursor.hasNext()) {

                DBObject Features = cursor.next();

                BasicDBList features = (BasicDBList) Features.get("features");

                BasicDBObject[] featuresArr = features.toArray(new BasicDBObject[0]);

                for (BasicDBObject dbobj : featuresArr) {

                    BasicDBObject geometry = (BasicDBObject) dbobj.get("geometry");

                    BasicDBList coordinates = (BasicDBList) geometry.get("coordinates"); // BasicDBList contains coordinates

                    System.out.println(coordinates.get(0));

                }

            }
        } finally {
            cursor.close();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}