@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_item);

    db = new DatabaseHelper(this).getWritableDatabase();

    ...
}