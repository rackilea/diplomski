private void copyDataBase() throws IOException {

    final String TAG = "COPYDATABASE";

    //Open your local db as the input stream
    Log.d(TAG,"Initiated Copy of the database file " + DB_NAME + " from the assets folder.");
    InputStream myInput = myContext.getAssets().open(DB_NAME); // Open the Asset file
    String dbpath = myContext.getDatabasePath(DB_NAME).getPath();
    Log.d(TAG,"Asset file " + DB_NAME + " found so attmepting to copy to " + dbpath);

    // Path to the just created empty db
    //String outFileName = DB_PATH + DB_NAME;
    //Open the empty db as the output stream
    File outfile = new File(myContext.getDatabasePath(DB_NAME).toString());
    Log.d("DBPATH","path is " + outfile.getPath());
    outfile.setWritable(true); //<<<<<<<<<< not required as writable access exists
    //OutputStream myoutputx2 = new FileOutputStream(outfile);
    if (!outfile.getParentFile().exists()) {
        outfile.getParentFile().mkdirs();
    }

    OutputStream myOutput = new FileOutputStream(outfile);
    //transfer bytes from the inputfile to the outputfile
    byte[] buffer = new byte[buffer_size];
    int length;
    while ((length = myInput.read(buffer))>0) {
        blocks_copied++;
        Log.d(TAG,"Ateempting copy of block " + String.valueOf(blocks_copied) + " which has " + String.valueOf(length) + " bytes.");
        myOutput.write(buffer, 0, length);
        bytes_copied += length;
    }
    Log.d(TAG,
            "Finished copying Database " + DB_NAME +
                    " from the assets folder, to  " + dbpath +
                    String.valueOf(bytes_copied) + "were copied, in " +
                    String.valueOf(blocks_copied) + " blocks of size " +
                    String.valueOf(buffer_size) + "."
    );
    //Close the streams
    myOutput.flush();
    myOutput.close();
    myInput.close();
    Log.d(TAG,"All Streams have been flushed and closed.");
}