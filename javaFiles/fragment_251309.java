private ListView lv = (ListView) findViewById(R.id.your_list_view_id);

List<String> your_array_list = new ArrayList<String>();
String path = Environment.getExternalStorageDirectory().toString()+"/Church Application/";

File f = new File(path);
File[] files = f.listFiles();
for (File inFile : files) {
    if (inFile.isDirectory()) {
        // in here, you can add directory names into an ArrayList and populate your ListView.
        your_array_list.add(inFile.getName());
    }
}

 ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                 this, 
                 android.R.layout.simple_list_item_1,
                 your_array_list );

         lv.setAdapter(arrayAdapter);