import com.mongodb.*;

public class MongoTest {

    public static void main(String[] args) throws Exception {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("myGameDB");
        DBCollection gameCollection = db.getCollection("myGameCollection");
        BasicDBObject obj = new BasicDBObject().append("sever", "the_server_name");
        BasicDBList players = new BasicDBList();
        BasicDBList list1 = new BasicDBList();
        BasicDBList list2 = new BasicDBList();
        list1.addAll(java.util.Arrays.asList(new String[]{"kit1", "kit2"}));
        list2.addAll(java.util.Arrays.asList(new String[]{"kit1", "kit2"}));
        BasicDBObject playerObj1 = new BasicDBObject("player", "the_players_username").append("kits", list1);
        BasicDBObject playerObj2 = new BasicDBObject("player", "the_players_username").append("kits", list2);
        players.add(playerObj1);
        players.add(playerObj2);
        obj.append("players", players);
        gameCollection.insert(obj);
        printCollectionContent(gameCollection);
    }


    static void printCollectionContent(DBCollection coll) {
        BasicDBObject query = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject("server", true).append("_id", false).append("players",true);
        DBCursor curs = coll.find(query);
        while (curs.hasNext()) {
            DBObject o = curs.next();
            System.out.println(o.toString());
        }
        curs = coll.find(query, fields);
        while (curs.hasNext()) {
            DBObject o = curs.next();
            System.out.println(o.toString());
        }
    }
}