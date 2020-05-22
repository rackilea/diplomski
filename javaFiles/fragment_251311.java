private ListView lv = (ListView) findViewById(R.id.your_list_view_id);

List<String> your_array_list = new ArrayList<String>();
String path = Environment.getExternalStorageDirectory().toString()+"/Church Application/";

File f = new File(path);
File[] files = f.listFiles();
for (File inFile : files) {
    if (inFile.isDirectory()) {
        // If this folder is empty, delete it.
        if (inFile.listFiles().length == 0) {
            inFile.delete();
         // If not, add to ArrayList 
        } else if (inFile.listFiles().length >= 1) {
            your_array_list.add(inFile.getName());
        } 
    }
}

 ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                 this, 
                 android.R.layout.simple_list_item_1,
                 your_array_list );

         lv.setAdapter(arrayAdapter);