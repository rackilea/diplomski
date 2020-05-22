URL url = new URL("http://abc.com");
HttpURLConnection con = (HttpURLConnection) url.openConnection();

try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));)
{
    StringBuilder sb = new StringBuilder();

    String str = null;

    while (null != (str = reader.readLine()))
        sb = sb.append(str);

    resStr = sb.toString();
}

con.disconnect();