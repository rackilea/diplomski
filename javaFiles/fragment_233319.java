import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SqlLiteFishLoggerDao extends SQLiteOpenHelper implements
        FishLoggerDao {

    private static final String DB_NAME = "fishingLog";

    private static final String TABLE_NAME = "LogEntries";

    private static final String DELETE_LOG_ENTRY_SQL = "DELETE FROM LogEntries WHERE _id = ?;";

    private static final String FIND_LOG_ENTRY_SQL = "SELECT * FROM LogEntries WHERE _id = ?";

    private static final String FIND_ALL_ENTRIES_SQL = "SELECT * FROM LogEntries";

    private static final String[] NO_ARGS = {};

    private Context context;

    private SQLiteDatabase DB;

    public SqlLiteFishLoggerDao(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void deleteLogEntry(String id) {
        DB = getWritableDatabase();
        DB.execSQL(DELETE_LOG_ENTRY_SQL, new Object[] { id });
        DB.close();
    }

    @Override
    public LogEntry findEntry(String id) {
        DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery(FIND_LOG_ENTRY_SQL,
                new String[] { id });
        if (!cursor.moveToFirst()) {
            return null;
        }
        LogEntry entry = new LogEntry();
        entry.setId(cursor.getString(cursor.getColumnIndex("_id")));
        entry.setEntryDate(cursor.getString(cursor.getColumnIndex("CreateDate")));
        entry.setSpecies(cursor.getString(cursor.getColumnIndex("Species")));
        entry.setSizeOrWeight(cursor.getString(cursor.getColumnIndex("SizeOrWeight")));
        entry.setLatitude(cursor.getDouble(cursor.getColumnIndex("Latitude")));
        entry.setLongitude(cursor.getDouble(cursor.getColumnIndex("Longitude")));
        entry.setPictureUrl(cursor.getString(cursor.getColumnIndex("PictureURL")));

        cursor.close();
        DB.close();
        return entry;

    }

    @Override
    public void insertLogEntry(LogEntry entry) {
        DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Latitude", entry.getLatitude());
        values.put("Longitude", entry.getLongitude());
        values.put("PictureURL", entry.getPictureUrl());
        values.put("SizeOrWeight", entry.getSizeOrWeight());
        values.put("CreateDate", entry.getEntryDate());
        values.put("Species", entry.getSpecies());
        DB.insertOrThrow("LogEntries", null, values);
        DB.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String s;
        try {
            InputStream in = context.getResources().openRawResource(R.raw.sql);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            Document doc = builder.parse(in, null);
            NodeList statements = doc.getElementsByTagName("statement");
            for (int i = 0; i < statements.getLength(); i++) {
                s = statements.item(i).getChildNodes().item(0).getNodeValue();
                db.execSQL(s);
            }
            Log.e("DB", "DB Created Successfully");
        } catch (Throwable t) {
            Log.e("DB error: ",t.toString());
        }
    }

    @Override
    public List<LogEntry> findAllEntries() {
        DB = getReadableDatabase();

        List<LogEntry> entries = new ArrayList<LogEntry>();

        Cursor cursor = DB.rawQuery(FIND_ALL_ENTRIES_SQL,
                NO_ARGS);

        if (cursor.moveToFirst()) {
            do {
                LogEntry entry = new LogEntry();
                entry.setId(cursor.getString(cursor.getColumnIndex("_id")));
                entry.setEntryDate(cursor.getString(cursor.getColumnIndex("CreateDate")));
                entry.setSpecies(cursor.getString(cursor.getColumnIndex("Species")));
                entry.setSizeOrWeight(cursor.getString(cursor.getColumnIndex("SizeOrWeight")));
                entry.setLatitude(cursor.getDouble(cursor.getColumnIndex("Latitude")));
                entry.setLongitude(cursor.getDouble(cursor.getColumnIndex("Longitude")));
                entry.setPictureUrl(cursor.getString(cursor.getColumnIndex("PictureURL")));

                if (entry.getSpecies() == null) {
                    entry.setSpecies("Not Entered");
                }

                if (entry.getSizeOrWeight() == null) {
                    entry.setSizeOrWeight("Not entered");
                }

                entries.add(entry);
            } while (cursor.moveToNext());
        }
        cursor.close();
        DB.close();
        return entries;
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB = getWritableDatabase();
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(getWritableDatabase());
        DB.close();
    }
}