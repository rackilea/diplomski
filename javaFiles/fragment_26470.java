public void onClickBack(View view)
{
    setContentView(R.layout.activity_main);
    ListView lv = (ListView) findViewById(R.id.listView);
    lv.setAdapter(simpleAdpt);

}