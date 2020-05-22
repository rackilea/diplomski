private static DatabaseHelper instance;

private DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, 1);
}

public static DatabaseHelper getInstance(Context context) {
    if (instance == null) {
        instance = new DatabaseHelper(context.getApplicationContext());
    }
    return instance;
}