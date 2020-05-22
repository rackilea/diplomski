File sdcard = Environment.getExternalStorageDirectory();
        File f = new File(sdcard, "/yourfile");

if(!f.exsist()){
f.createNewFile();
//Use outwriter here, outputstream search how to write into a file in java code 
}