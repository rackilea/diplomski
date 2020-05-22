DatabaseAdapter db;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    db = new DatabaseAdapter(this);

    setContentView(R.layout.activity_main);

}