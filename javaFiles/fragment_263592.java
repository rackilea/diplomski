BufferedReader reader = new BufferedReader(new InputStreamReader(in_stream), "UTF-8");
    StringBuilder content = new StringBuilder();
    String line = null;
    try
    {
        while ((line = reader.readLine()) != null) 
        {
            content.append(line + "\n");
        }

    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    } 
    finally 
    {
        try 
        {
            in_stream.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    ret = content.toString();