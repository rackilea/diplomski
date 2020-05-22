private static String DB_NAME = DATABASE_NAME;

private SQLiteDatabase myDataBase;

private final Context myContext;

private static DataBaseHelper databaseHelperInstance;
private DataBaseHelper(Context context) {

    super(context, DB_NAME, null, 1);
    this.myContext = context;
}
public static synchronized DataBaseHelper getInstance(Context c) {
    if (databaseHelperInstance == null) {
        synchronized (DataBaseHelper.class) {
            databaseHelperInstance = new DataBaseHelper(c);
        }
    }
    return databaseHelperInstance;
}