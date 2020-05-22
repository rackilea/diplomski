@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);  

    MyView myView = new MyView(this);
    setContentView(myView);
}