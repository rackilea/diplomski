private void writeLog(String s)
{
    String FILENAME = "log.txt";
    FileOutputStream fos = null;
    try
    {
        fos = openFileOutput(FILENAME, Context.MODE_APPEND);
        fos.write(s.getBytes());
    }
    catch(FileNotFoundException e){}
    catch(IOException e){}
    finally
    {
        try
        {
            fos.close();
        }
        catch(IOException e){}
    }
}