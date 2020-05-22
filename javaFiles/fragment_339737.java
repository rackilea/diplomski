private void readLog(EditText logs)
{
    String FILENAME = "log.txt";
    FileInputStream in = null;
    try
    {
        in = openFileInput(FILENAME);
    }
    catch(IOException e1){}
    try
    {
        byte[] buffer = new byte[4096]; // Read 4K characters at a time.
        int len;
        logs.setText("");
        while((len = in.read(buffer)) != -1)
        {
            String s = new String(buffer, 0, len);
            logs.append(s);
        }
    }
    catch(IOException e){}
    finally
    {
        try
        {
            if(in != null) in.close();
        }
        catch(IOException e){}
    }
}