@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String e1 = getIntent().getStringExtra("detail_1");
    String e2 = getIntent().getStringExtra("detail_2");
    String e3 = getIntent().getStringExtra("detail_3");
    int icon = getIntent().getIntExtra("detail_icon", 0);
    Example e = new Example(e1, e2, icon, e3);


}