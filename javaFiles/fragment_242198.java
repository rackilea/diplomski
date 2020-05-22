@Override
public void onResume() {
    super.onResume(); 
    ArrayList<String> theList =new ArrayList<>();
    Cursor data= mydb.getAllData();
    listView.setAdapter(null);

    if (data.getCount()==0){
        Toast.makeText(MainActivity.this,"data not inserted",Toast.LENGTH_LONG).show();
    }
    else
    {
        while(data.moveToNext()){
            theList.add(data.getString(1));
            ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
            listView.setAdapter(listAdapter);
        }
    }
}