File testFolder = new File(
            Environment.getExternalStorageDirectory(),
            "ABCPrint");
if (!testFolder.exists())
{
    try
    {
        testFolder.createNewFile();
    } 
    catch (IOException e){
        e.printStackTrace();
    }
}
try
{
    //BufferedWriter for performance, true to set append to file flag
    BufferedWriter buf = new BufferedWriter(new FileWriter(testFolder, true)); 
    buf.append("Hello World!");
    buf.newLine();
    buf.close();
}
catch (IOException e){
    e.printStackTrace();
}