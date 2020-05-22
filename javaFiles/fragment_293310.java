public DBController_for_drivinglicense(Context applicationcontext) {
    super(applicationcontext,"nozadb", null, 2);
}
//Creates Table
@Override
public void onCreate(SQLiteDatabase database) {

    String query;
    query = "CREATE TABLE if not exists drivinglicense ( id INTEGER PRIMARY KEY, comment TEXT,rates float,names TEXT,date DEFAULT CURRENT_TIMESTAMP, udpateStatus TEXT)";
    database.execSQL(query);

}