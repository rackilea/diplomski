@Override
public void onCreate(SQLiteDatabase db) {
String sql =
        "CREATE TABLE IF NOT EXISTS users (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT NOT NULL, " +
                "password TEXT NOT NULL);";
db.execSQL(sql);

sql = "INSERT INTO users(name, password) VALUES ('testuser', 'textpassword')";
db.execSQL(sql);
}

AUTOINCREMENT NOT NULL is missing in your insert query which will increase the value of _id field automatically.