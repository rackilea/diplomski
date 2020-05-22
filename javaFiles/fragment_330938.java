public class MongoTest {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create();
        MongoDatabase testDb = client.getDatabase("test");
        MongoCollection<Document> collectionA = testDb.getCollection("test");
        MongoCollection<Document> collectionB = testDb.getCollection("runoob");

        Document first = collectionA.find().first();
        Date lastOptTime = first.getDate("lastOptTime");

        ObjectId fakeObjectId = objectIdFromDate(lastOptTime);

        FindIterable<Document> documents =
                collectionB.find(Filters.gte("_id", fakeObjectId));
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public static ObjectId objectIdFromDate(Date date) {
        long second = date.getTime() / 1000;
        return new ObjectId(String.format("%02x", second) + "0000000000000000");
    }
}