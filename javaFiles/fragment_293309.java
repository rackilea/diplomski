public DBController_for_landregistration(Context applicationcontext) {
    super(applicationcontext,"nozadb", null, 1);
}

@Override
public void onCreate(SQLiteDatabase database) {
    String query;

    query = "CREATE TABLE if not exists landregistration ( id INTEGER PRIMARY KEY, comment TEXT,rates float,names TEXT,date DEFAULT CURRENT_TIMESTAMP, udpateStatus TEXT)";
    database.execSQL(query);

}