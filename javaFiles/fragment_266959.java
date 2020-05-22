private void deleteOldestFile(File directory)
{
File[] files = directory.listFiles();
Arrays.sort(files, new Comparator<File>() { 
    @Override
    public int compare(File f1, File f2) 
    {       
        return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());        
    }});

files[0].delete();
 }

private static long dirSize(File dir) {
long result = 0;
File[] fileList = dir.listFiles();

for(int i = 0; i < fileList.length; i++) {

    if(fileList[i].isDirectory()) {
        result += dirSize(fileList [i]);
    } else {
        // Sum the file size in bytes
        result += fileList[i].length();
    }
 }
return result; 
}