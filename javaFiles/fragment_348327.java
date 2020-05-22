protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main3);
Intent intent=getIntent();
list=(ListView)findViewById(R.id.listview);
list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(getApplicationContext());

    }
});