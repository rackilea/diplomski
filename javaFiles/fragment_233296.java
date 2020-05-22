public class MyDatabaseHelper{
    private Context context;
    public MyDatabaseHelper(Context context, String name, CursorFactory factory,
            int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        String yourString = context.getResources().getString(R.string.value);
        //do what ever you like with your string.
    }
}