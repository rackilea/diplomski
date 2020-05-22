private String readFileFromAssets(String filename)
{
StringBuilder sb = new StringBuilder();
try
{
    BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open(filename), "UTF-8"));

    // do reading, usually loop until end of file reading
    String mLine = reader.readLine();
    while(mLine != null)
    {
    // process line
    sb.append(mLine);
    mLine = reader.readLine();
    }

    reader.close();
} catch(IOException e)
{
    // log the exception
    e.printStackTrace();
}

return sb.toString();
}