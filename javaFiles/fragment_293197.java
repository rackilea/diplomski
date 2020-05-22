@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MyView view = (MyView)findViewById(R.id.my_view);
    view.setHeight(50);
}