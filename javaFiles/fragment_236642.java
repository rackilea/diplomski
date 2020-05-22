public static final String EXTRA_ARRAY = "com.example.androidtest.mainactivity.array";

ArrayList<String> myList;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activityb_layout);
    myList = (ArrayList<String>) getIntent().getSerializableExtra(EXTRA_ARRAY);

    for (int i = 0; i < 10; i++) {
        myList.add(String.valueOf(i));
    }

    Intent data = new Intent();
    data.putExtra(EXTRA_ARRAY, myList);
    setResult(Activity.RESULT_OK, data);

    finish();
}