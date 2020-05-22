@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lec_refer_room);

    String subCode = null;
    TastkTest tasktest = new TaskTest();
    tasktest.execute(subCode);

}