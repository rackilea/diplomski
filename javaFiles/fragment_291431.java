private File[] listFile;
ArrayList<String> f = new ArrayList<String>();

public void getFromSdcard()
{
    File file = new File(android.os.Environment.getExternalStorageDirectory(),"MyFolder");

        if (file.isDirectory())
        {
            listFile = file.listFiles();
             for (int i = 0; i < listFile.length; i++)
            {
                f.add(listFile[i].getAbsolutePath());
            }   

        }
}