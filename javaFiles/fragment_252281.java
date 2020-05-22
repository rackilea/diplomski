CSVWriter csvWrite = null;
 try {
         csvWrite = new CSVWriter(new FileWriter(file));
 } catch (IOException ex) {
    Log.e(LOG_TAG, ex.getMessage(), ex);
    return; // or System.exit or what either
 }