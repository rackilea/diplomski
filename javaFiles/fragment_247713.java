String path = Environment.getExternalStorageDirectory().toString()+"/MyDir";
Log.d("Files", "Path: " + path);
File f = new File(path);        
File file[] = f.listFiles();
Log.d("Files", "Size: "+ file.length);
for (int i=0; i < file.length; i++)
{
    file[i].renameTo(file[i].getName() + "x");
}