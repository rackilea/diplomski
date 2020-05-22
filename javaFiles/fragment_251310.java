String path = Environment.getExternalStorageDirectory().toString()+"/Church Application/";

File f = new File(path);
File[] files = f.listFiles();
for (File inFile : files) {
    if (inFile.isDirectory()) {
        // If this folder is empty, delete it.
        if (inFile.listFiles().length == 0) {
            inFile.delete();
        }
    }
}