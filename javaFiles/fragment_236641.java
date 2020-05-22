private static final int REQUEST_LIST = 1;
ArrayList<String> myList;
TextView listText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    listText = (TextView) findViewById(R.id.mylist_text);
    myList = new ArrayList<String>();

    Intent i = new Intent(MainActivity.this, ActivityB.class);
    i.putExtra(ActivityB.EXTRA_ARRAY, myList);
    startActivityForResult(i, REQUEST_LIST);

}

@Override
protected void
        onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode != Activity.RESULT_OK) return;

    if (requestCode == REQUEST_LIST) {
        myList = (ArrayList<String>) data.getSerializableExtra(ActivityB.EXTRA_ARRAY);

        StringBuilder text = new StringBuilder();
        for (int j = 0; j < myList.size(); j++) {
            text.append(myList.get(j) + " ");
        }

        listText.setText(text.toString());
    }
}