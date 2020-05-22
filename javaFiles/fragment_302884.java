public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Mag_Positioning.db";
    private static final int DB_VERSION = 1;
    private static final String COL_ID = "ID";
    private static final String COLXAXIS = "X_AXIS";
    private static final String TABLENAME = "MAP_COORDINATES";
    private static final String COLYAXIS = "Y_AXIS";
    private static final String COLZAXIS = "Z_AXIS";

    private static DBHelper mInstance;

    private DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DBHelper getInstance() {
        if (mInstance == null) {
            synchronized (DBHelper.class) {
                if (mInstance == null) {
                    mInstance = new DBHelper(BaseApp.getApp());
                }
            }
        }

        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLENAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLXAXIS + " REAL, " +
                COLYAXIS + " REAL, " +
                COLZAXIS + " REAL )";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(db);
    }

    public void insert(float x, float y, float z) {

        ContentValues contentvalues = new ContentValues();
        contentvalues.put("X-AXIS", x);
        contentvalues.put("Y-AXIS", y);
        contentvalues.put("Z-AXIS", z);
        getWritableDatabase().insert("MAP_COORDINATES", null, contentvalues);
    }
}