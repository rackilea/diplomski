private String getUrlContents(String Url) 
{
    StringBuilder content = new StringBuilder();
    try {
        URL url = new URL(Url);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()), 8);
        String line;
        while ((line = bufferedReader.readLine()) != null) 
        {
            content.append(line + "\n");
        }
        bufferedReader.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return content.toString();
}