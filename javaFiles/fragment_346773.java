@Override
protected void onResume() {
    super.onResume();

    listView.setAdapter(grade_adapter);
    db_operation_helper=new Db_operation_helper(getApplicationContext());
    sqLiteDatabase=db_operation_helper.getReadableDatabase();
    cursor=db_operation_helper.grade_get(sqLiteDatabase);
    if(cursor.moveToFirst())
    {
      do {
           String head;
           head=cursor.getString(0);
           DataProvider dataProvider=new DataProvider(head);
           grade_adapter.add(dataProvider);
           grade_adapter.notifyDataSetChanged();
         }while (cursor.moveToNext());
     }

}

protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.grade_book);
toolbar=(Toolbar)findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
getSupportActionBar().setTitle("Grade Book");
getSupportActionBar().setHomeButtonEnabled(true);
getSupportActionBar().setDisplayHomeAsUpEnabled(true);

listView= (ListView) findViewById(R.id.gradeList);
grade_adapter=new Grade_Adapter(getApplicationContext(),R.layout.grade_book_listview1);

registerForContextMenu(listView);    

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getBaseContext(),"YOU",Toast.LENGTH_LONG).show();
        view.setSelected(true);
    }
});
}