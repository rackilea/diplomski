@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_item);

    DatabaseHelper db = new DatabaseHelper(this);

    ...
}