private static final int VERSION=2;

public DatabaseHelper(Context context) {
    super(context, DBNAME , null,VERSION);
    this.context = context;
}