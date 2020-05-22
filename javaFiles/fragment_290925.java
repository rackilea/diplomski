public static String readPage(String url, String delimeter)
{
    try
    {
        URL URL = new URL(url);
        URLConnection connection = URL.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line, lines = "";
        while ((line = reader.readLine()) != null)
        {
            if(lines != "")
            {
                lines += delimeter;
            }
            lines += line;
        }
        return lines;
    }
    catch (Exception e)
    {
        return null;
    }
}