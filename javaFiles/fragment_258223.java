String baseURL = "google.com";

try
{
     java.net.URL url = new java.net.URL("http://" + baseURL);
     java.net.HttpURLConnection connection = (HttpURLConnection)url.openConnection();
     connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");

     int response = connection.getResponseCode();
     System.out.println("Response code: " + response);

     if (response == 301 || response == 302 || response == 303)
     {
            System.out.println("Redirect location: " + connection.getHeaderField("Location"));
     }

     else
     {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            int lineCount = 0;

            while ((line = in.readLine()) != null)
            {
            lineCount++;
            }

            System.out.println("http://" + baseURL + " = " + lineCount + " lines\n");
     }
}

catch (Exception ex)
{
     System.out.println("http://" + baseURL + " throws an error\n");
}