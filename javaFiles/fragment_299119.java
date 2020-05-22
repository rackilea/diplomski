public void save(String filename) {

    EditText[] somelist = {predmet1,predmet2,predmet3};
    File root = Environment.getExternalStorageDirectory();
    try {
        FileWriter fw = new FileWriter(new File(root + "/" + filename));
        BufferedWriter out = new BufferedWriter(fw);
        for (EditText ed : somelist){
            out.write(ed.getText().toString());
            out.write("\n");
        }
        out.close();
    } catch (IOException e) {
        Log.d("Katja app", Util.stackTraceWriter(e));
    }

}