listView.setOnItemClickListener(new OnItemClickListener(){

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
         String item = (String) parent.getItemAtPosition(int position);
         item += "YourText";
         ArrayAdapter adapter = (ArrayAdapter ) parent.getAdapter();
         adapter.insert(item, position);
    }