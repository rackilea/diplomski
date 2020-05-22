public class DatabaseHlpr extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "mytable";
    public static final String MYTABLE_COL_ID = BaseColumns._ID;
    public static final String MYTABLE_COL_COMMON = "common";
    public static final String MYTABLE_COL_SCHEMA1ONLY = "schema1only";

    private int mSchema;
    private SQLiteDatabase mDB;


    public DatabaseHlpr(@Nullable Context context, @Nullable String name, int schema) {
        super(context, name, null,1);
        this.mSchema = schema;
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        switch (mSchema) {
            case 1:
                useSchema1(db);
                break;
            default:
                useSchema0(db);
        }
    }

    private void useSchema1(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                MYTABLE_COL_ID + " INTEGER PRIMARY KEY, " +
                MYTABLE_COL_COMMON + " TEXT, " +
                MYTABLE_COL_SCHEMA1ONLY + " TEXT " +
                ")");
    }

    private void useSchema0(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" +
                MYTABLE_COL_ID + " INTEGER PRIMARY KEY, " +
                MYTABLE_COL_COMMON + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}