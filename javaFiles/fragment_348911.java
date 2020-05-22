@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ```your code

    Intent intent = getIntent();
    String source = intent.getStringExtra("source");
    if (source.equals("onClick")) {
        bottomBar.onTabSelected(R.id.tab_book);
    }
}