ListView myListView=(ListView)findViewById(R.id.myListView);

ArrayList<String> myList=new ArrayList<String>();

myList.add("khan");
myList.add("Gul");

ArrayAdapter<String> arrays=new ArrayAdapter<String>(this, 
android.R.layout.simple_list_item_1,myList);