public void selectFolder(){

    // Instantiate an AlertDialog.Builder with its constructor
    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    // Chain together various setter methods to set the dialog characteristics
    builder.setTitle("Choose folder to save profile");

    // Get the layout inflater
    LayoutInflater inflater = this.getLayoutInflater();
    final View dialogView = inflater.inflate(R.layout.dialog_selectfolder, null);

    ListView lvDirectories = (ListView) dialogView.findViewById(R.id.lvDirectories);
    String path = Environment.getExternalStorageDirectory().toString();
    ((TextView) dialogView.findViewById(R.id.tvJamesBond)).setText(path);

    final ArrayList<String> items = listFolders(path);
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);


    lvDirectories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String dest = ((ListView) dialogView.findViewById(R.id.lvDirectories)).getItemAtPosition(i).toString().trim();
            String path;
            if(dest.compareTo("...")==0){
                int lastSlash = ((TextView) dialogView.findViewById(R.id.tvJamesBond)).getText().toString().lastIndexOf("/");
                path =  ((TextView) dialogView.findViewById(R.id.tvJamesBond)).getText().toString().substring(0,lastSlash);
            }
            else{
                path = ((TextView) dialogView.findViewById(R.id.tvJamesBond)).getText().toString() + "/" + dest;
            }
            items.clear();
            items.addAll(listFolders(path));
            ((TextView) dialogView.findViewById(R.id.tvJamesBond)).setText(path);
            adapter.notifyDataSetChanged();
        }
    });

    lvDirectories.setAdapter(adapter);
    adapter.notifyDataSetChanged();
    builder.setView(dialogView);

    // Add the buttons
    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            saveProfile(((TextView) dialogView.findViewById(R.id.tvJamesBond)).getText().toString());
        }
    });

    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            Toast toast = Toast.makeText(getApplicationContext(), "Nothing saved", Toast.LENGTH_SHORT);
            toast.show();
        }
    });

    // Get the AlertDialog from create()
    AlertDialog dialog = builder.create();
    dialog.show();

}

public ArrayList<String> listFolders(String path){
    ArrayList<String> result = new ArrayList<String>();
    File f = new File(path);
    File[] files = f.listFiles();
    Log.d("TEST PATH1", path);
    Log.d("TEST PATH1", Environment.getExternalStorageDirectory().toString());
    if(path.compareTo(Environment.getExternalStorageDirectory().toString())!=0){
        result.add("...");
    }
    for (File inFile : files) {
        if (inFile.isDirectory()) {
            result.add(inFile.getName());
        }
    }

    return result;
}

public void saveProfile(String folder){

    String fileName = "default.txt";

    try{
        String ob = new Gson().toJson(((MyApplication)getApplication()).getProfile());
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(folder+"/"+fileName));
        outputStreamWriter.write(ob);
        outputStreamWriter.close();
    }
    catch(IOException ex){
        Log.e("SAVE_FILE", ex.toString());
    }

    Toast toast = Toast.makeText(getApplicationContext(), "Profile saved to file '"+fileName+"'", Toast.LENGTH_SHORT);
    toast.show();

}