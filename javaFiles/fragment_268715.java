@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    IotdHandler handler = new IotdHandler ();
    new MyTask().execute();
}