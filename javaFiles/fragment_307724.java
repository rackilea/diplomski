import com.mongodb.MongoClient; 
import com.mongodb.MongoException; 
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;

public class myfile {

    DB db; 

    public myfile {
        initDB();
    }

    public void initDB() {
        MongoClient mongoclient = new MongoClient("localhost",27017);
        db = mongoclient.getDB("test1");
    }

    ...


}