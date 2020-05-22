@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    etxt = (EditText) findViewById(R.id.editText);


     if (getIntent().hasExtra("editnote_text") && getIntent().hasExtra("2") && 
 getIntent().hasExtra("3")) {

        t = (File) getIntent().getExtras().get("editnote_text");
        s = getIntent().getStringExtra("2");
        b = getIntent().getStringExtra("3");
        etxt.setText(gettextfromfile2(t), TextView.BufferType.EDITABLE);
    }

    getWindow().setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    String g = "abc"; //this String is only added for testing
    etxt.setText(g);
    ordner = new File(Environment.getExternalStorageDirectory(), "test_notizenapp");
    if (!ordner.exists()) {
        ordner.mkdir();
    }
}