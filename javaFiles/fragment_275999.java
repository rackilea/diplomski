public class CustomDaoMaster extends DaoMaster {
    public CustomDaoMaster(SQLiteDatabase db) {
        super(db);
    }

    public static class OpenHelper extends DaoMaster.OpenHelper {
        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            super.onCreate(db);
            db.execSQL("INSERT INTO myTable VALUES('foo')");
            db.execSQL("INSERT INTO myTable VALUES('bar')");
        }
    }
}