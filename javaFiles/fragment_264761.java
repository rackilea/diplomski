public class DBHelper001 extends SQLiteOpenHelper {

    public static final String DBNAME = "db";
    public static final int DBVERSION =1;

    public static final String TABLE_PLAYER = "player_card";
    public static final String COL_PLAYERCARD_CARD = "card";
    public static final String COL_PLAYERCARD_EMAIL = "email";
    public static final String COL_PLAYERCARD_REGION = "region";
    public static final String COL_PLAYERCARD_Q = "quantidade";

    SQLiteDatabase mDB;

    public DBHelper001(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase(); //<<<<<<<<<< when helper is instantiated will force on Create and thus the logIt method to run.
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mDB = db;
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_PLAYER + "(" +
                COL_PLAYERCARD_CARD + " TEXT, " +
                COL_PLAYERCARD_EMAIL + " TEXT, " +
                COL_PLAYERCARD_REGION + " TEXT," +
                COL_PLAYERCARD_Q + " INTEGER," +
                "PRIMARY KEY (" +
                COL_PLAYERCARD_EMAIL + "," +
                COL_PLAYERCARD_REGION + "," +
                COL_PLAYERCARD_CARD + ")" +
                ")"
        );
        //<<<<<<<<<< Add some test data
        insertPlayerCard("card1","a@x.id","EU",1);
        insertPlayerCard("card2","a@x.id","EU",1);
        insertPlayerCard("card1","a@x.id","US",1);
        //<<<<<<<<<< INVOKE THE LOGIT METHOD >>>>>>>>>>
        logIt();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long insertPlayerCard(String card, String email, String region, long quantitade) {
        ContentValues cv = new ContentValues();
        cv.put(COL_PLAYERCARD_CARD,card);
        cv.put(COL_PLAYERCARD_EMAIL,email);
        cv.put(COL_PLAYERCARD_REGION,region);
        cv.put(COL_PLAYERCARD_Q,quantitade);
        return mDB.insert(TABLE_PLAYER,null,cv);
    }

    //<<<<<<<<<< THE LOGIT METHOD RUNS QUERY AS COPIED AND REPORTS ROWS EXTRACTED >>>>>>>>>>
    public void logIt() {
        String sql = "SELECT * FROM player_card " +
                "WHERE email " +
                "In (SELECT email FROM player_card As Tmp " +
                "   GROUP BY email, card " +
                "   HAVING COUNT(*) > 1 AND card = player_card.card) " +
                "   ORDER BY email;";
        Cursor csr = mDB.rawQuery(sql,null);
        Log.d("RESULT","Number of rows extracted = " + String.valueOf(csr.getCount()));
        csr.close();
    }
}