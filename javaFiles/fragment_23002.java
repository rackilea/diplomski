public void writeFile(String data){
        try {
            File logFile = new File(Environment.getExternalStorageDirectory().toString(), ".YOURAPP/myFile.txt");
            File dirFile = new File(Environment.getExternalStorageDirectory().toString(), ".YOURAPP");
            if(!logFile.exists()) {
                dirFile.mkdir();
                logFile.createNewFile();
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(logFile));
            output.write(data);
            output.close();
        }catch (Exception e){
            System.out.print("Exception e"+e);
        }
    }