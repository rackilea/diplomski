public class Database{
    private static SQLiteDatabase localDatabase = null;
    private Database(){}

    public static SQLiteDatabase getLocalDatabase(){
        if (localDatabase == null){
            localDatabase = SQLiteDatabase.openOrCreateDatabase(...);
        }
        return localDatabase;
    }
}