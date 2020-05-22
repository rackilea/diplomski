@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        ListView ls = (ListView) findViewById(R.id.listView);
        Adapter adapter = new Adapter(this);
        ls.setAdapter(adapter);
    }