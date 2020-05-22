public abstract class GeneralFriendsTable {

    public abstract String getTableName();

    public static void onCreate(SQLiteDatabase db) {
        String DATABASE_CREATE = "CREATE TABLE " + getTableName() + ...
    }
}