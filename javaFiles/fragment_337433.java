public static void main(String[] args) throws IOException
{
  URL url = new URL("http://www.google.com");
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();

  connection.setRequestMethod("GET");

  String resp = getResponseBody(connection);

  System.out.println("RESPONSE CODE: " + connection.getResponseCode());
  System.out.println(resp);
}

private static String getResponseBody(HttpURLConnection connection)
    throws IOException
{
  try
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(
        connection.getInputStream()));

    StringBuilder responseBody = new StringBuilder();
    String line = "";

    while ((line = reader.readLine()) != null)
    {
      responseBody.append(line + "\n");
    }

    reader.close();
    return responseBody.toString();
  }
  catch (IOException e)
  {
    e.printStackTrace();
    return "";
  }
}