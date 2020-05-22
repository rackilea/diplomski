public class DiaryDatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "diary";
    public static final int DBVERSION = 1;
    public static final String DBATTACH = "attached";
    boolean attached = false;

    SQLiteDatabase sqLiteDatabase;

    public DiaryDatabaseHelper(Context context, boolean attached) {
        super(context, DBATTACH + DBNAME, null, DBVERSION);
        attached = true;
        sqLiteDatabase = this.getWritableDatabase();
    }

    public DiaryDatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Diary.getCrt_sql());
        /* Add some diaries */
        Diary ent1 = new Diary("Fred");
        Diary ent2 = new Diary("Mary");
        ContentValues cv = new ContentValues();
        cv.put(Diary.COLUMN_DIARYNAME,ent1.getDiaryName());
        db.insert(Diary.TABLENAME,null,cv);
        cv.clear();
        cv.put(Diary.COLUMN_DIARYNAME,ent2.getDiaryName());
        db.insert(Diary.TABLENAME,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllDiaryRows() {
        return sqLiteDatabase.query(Diary.TABLENAME,null,null,null,null,null,null);
    }
}