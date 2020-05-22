@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Intent intent = getIntent();
    MyInterface inter = (MyInterface) intent.getSerializableExtra("interface");

    ...
}