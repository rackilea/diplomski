import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Aggregation {

    public static void main(String[] args) {

        DB db = MongoDb.getAccountsDb();
        DBCollection ledger = db.getCollection("ledger");

        //------------------------------------------------- aggregation framework

        DBObject unwind = new BasicDBObject("$unwind", "$Accounts");
        List<Object> substrList = Arrays.asList(new Object[]{"$Accounts.Date", 3, -1});
        DBObject monthProjection = new BasicDBObject("$substr", substrList);
        DBObject projectFields = new BasicDBObject("Total_Credits", "$Accounts.Total_Credits");
        projectFields.put("Total_Debits", "$Accounts.Total_Debits");
        projectFields.put("month_year", monthProjection);
        DBObject project = new BasicDBObject("$project", projectFields );

        DBObject groupFields = new BasicDBObject( "_id", "$month_year");
        groupFields.put("Total_Credits", new BasicDBObject( "$sum", "$Total_Credits"));
        groupFields.put("Total_Debits", new BasicDBObject( "$sum", "$Total_Debits"));
        DBObject group = new BasicDBObject("$group", groupFields);

        AggregationOutput output = ledger.aggregate( unwind, project, group );

        System.out.println("\n" + output);
    }

}