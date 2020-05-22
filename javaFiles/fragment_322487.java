public class MyDatabaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String DATABASE_NAME = "Example.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_PASSWORD = "Password";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, (InputStream)null, DATABASE_PASSWORD);
    }
}