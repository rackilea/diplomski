public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        // Create new helper
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        // Get the database. If it does not exist, this is where it will
        // also be created.
        SQLiteDatabase db = dbHelper.getWriteableDatabase();

        // Create insert entries
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Table1.COLUMN_NAME_COL1, "value1");
        values.put(DatabaseContract.Table1.COLUMN_NAME_COL2, "value2");
        values.put(DatabaseContract.Table1.COLUMN_NAME_COL3, "value3");

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                 DatabaseContract.Table1.TABLE_NAME,
                 null,
                 values);
    }
}