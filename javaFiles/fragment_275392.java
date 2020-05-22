private void backupDatabase () throws IOException {
    String inFileName = "/data/data/com.gnd.example/databases/dados.db";
    File dbFile = new File (inFileName);
    FileInputStream fis = new FileInputStream (dbFile);

    String outFileName = Environment.getExternalStorageDirectory () + "/ example / backup / data.db";
    //<<<<<<<<<<< CODE ADDED >>>>>>>>>>
    File os = new File(outFileName); 
    if (!os.getParentFile().exists()) {
        os.getParentFile().mkdirs();
    }
    //<<<<<<<<<< END Of ADDED CODE >>>>>>>>>>
    OutputStream output = new FileOutputStream(os); //<<<<<<<<<< CHANGED
    byte [] buffer = new byte [1024];
    int length;
    while ((length = fis.read (buffer))> 0) {
        output.write (buffer, 0, length);
    }
    output.flush ();
    output.close ();
    fis.close ();
}