File dirlist = new File(Environment.getExternalStorageDirectory() + "/VideoList");

if(!(dirlist.exists()))
dirlist.mkdir();

Long directorySize = dirSize(dirlist);

 if (directorySize > 1073741824) // this is 1GB in bytes
 {
    deleteOldestFile(dirlist); 
 }

File TempFile = new File(Environment.getExternalStorageDirectory() 
                + "/VideoList", dateFormat.format(date) + fileFormat);
mediaRecorder.setOutputFile(TempFile.getPath());