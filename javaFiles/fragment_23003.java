public void deleteFile(){

        File logFile = new File(Environment.getExternalStorageDirectory().toString(), ".YOURAPP/myFile.txt");
        File dirFile = new File(Environment.getExternalStorageDirectory().toString(), ".YOURAPP");
        if(logFile.exists()) {
            logFile.delete();
            dirFile.delete();

        }
    }