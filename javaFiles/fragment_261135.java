@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    ArrayList<String> history = intent.getStringArrayListExtra("HistoryList");
    Collections.reverse(history);
    ListView historyList = getListView();
    ArrayAdapter<String> listAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, history);
    historyList.setAdapter(listAdapter);
}