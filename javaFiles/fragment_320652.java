@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ...
    setContentView(R.layout.activity_main);
    // you should call findViewById after calling setContentView
    spinner2 = (Spinner) findViewById(R.id.spinner2);
    ...
}