public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase mDB;

    public static final String DBNAME = "recipee";
    public static final int DBVERSION = 1;
    public static final String TABLE_RECIPES = "recipes";
    public static final String COLUMN_RECIPES_ID = BaseColumns._ID;
    public static final String COLUMN_RECIPES_NAME = "name";
    public static final String COLUMN_RECIPES_CATEGORY = "category";

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        mDB = db;
        String crt_recipes_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_RECIPES + "(" +
                COLUMN_RECIPES_ID + "INTEGER PRIMARY KEY," +
                COLUMN_RECIPES_NAME + " TEXT," +
                COLUMN_RECIPES_CATEGORY + " TEXT" +
                ")";
        db.execSQL(crt_recipes_sql);
        addRecipee("Egg on Toast","Breakfast");
        addRecipee("Bangers and Mash", "Dinner");
        addRecipee("Cheese Sandwich","Snack");
        addRecipee("Mud Cake","Desert");
        addRecipee("Spaghetti Bolognaise","Dinner");
        addRecipee("Blueberry Cheesecake","Desert");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public long addRecipee(String name, String category) {
        if (mDB == null) {
            mDB = this.getWritableDatabase();
        }
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_RECIPES_NAME,name);
        cv.put(COLUMN_RECIPES_CATEGORY,category);
        return mDB.insert(TABLE_RECIPES,null,cv);
    }

    public Cursor getRandomData(String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereclause = null;
        String[] whereargs = null;
        if (category.length() > 0 ) {
            whereclause = COLUMN_RECIPES_CATEGORY + " LIKE ?";
            whereargs = new String[]{"%" + category + "%"};
        }
        return db.query(TABLE_RECIPES,null,whereclause,whereargs,null,null,"random()","1");
        //Cursor res = db.rawQuery("SELECT * FROM "+TABLE_RECIPES+" ORDER BY RANDOM() LIMIT 1",null);
    }
}