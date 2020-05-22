public class CrdDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CardGame.db";
    public static final int DATABASE_VERSION = 1;

   SQLiteDatabase mDB;

    public CrdDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = this.getWriteableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CrdDBContract.GameEntry.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}