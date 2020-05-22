public class AndroidDatabaseAdapter extends DatabaseAdapter<android.database.Cursor> {
    public Cursor executeQuery(String query){
        Cursor cursor = db.rawQuery(query, selectionArgs);
        return cursor;
    }
}