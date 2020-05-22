package news.mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {
    public static final String MYDATABASE_NAME = "mobilealgerie.db";
    public static final String MYDATABASE_TABLE = "mobilealgerie";
    public static final int MYDATABASE_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_PUBDATE = "pubdate";

    // create table MY_DATABASE (ID integer primary key, Content text not null);
    private static final String SCRIPT_CREATE_DATABASE =
        "create table " + MYDATABASE_TABLE + " ("
      + KEY_ID + " integer primary key autoincrement, "
      + KEY_TITLE + " text not null ,"
      + KEY_DESCRIPTION + " text not null,"
      + KEY_PUBDATE + " text not null);";

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    private Context context;

    public SQLiteAdapter(Context c) {
        context = c;
    }

    public SQLiteAdapter openToRead() throws SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;  
    }

    public SQLiteAdapter openToWrite() throws SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;  
    }

    public void close() {
        sqLiteHelper.close();
    }

    public long insert(String TITLE, String DESCRIPTION, String PUBDATE) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TITLE, TITLE);
        contentValues.put(KEY_DESCRIPTION, DESCRIPTION);
        contentValues.put(KEY_PUBDATE, PUBDATE);
        return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
    }

    public int deleteAll() {
        return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
    }

    public Cursor queueAll() {
        String[] columns = new String[] {KEY_ID, KEY_TITLE, KEY_DESCRIPTION, KEY_PUBDATE};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns, 
            null, null, null, null, null);
        return cursor;
    }

    public class SQLiteHelper extends SQLiteOpenHelper {
        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }
}