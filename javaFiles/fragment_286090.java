HttpURLConnection httpURLConnection = null;
 try {
     // create URL
     URL url = new URL("http://example.com");
     // open connection
     httpURLConnection = (HttpURLConnection) url.openConnection();
     httpURLConnection.setRequestMethod("GET");
     // 15 seconds
     httpURLConnection.setConnectTimeout(15000);
     Uri.Builder builder = new Uri.Builder().appendQueryParameter("firstParameter", firsParametersValue).appendQueryParameter("secondParameter", secondParametersValue)
     String query = builder.build().getEncodedQuery();
     OutputStream outputStream = httpURLConnection.getOutputStream();
     BufferedWriter bufWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
     bufWriter.write(query);
     bufWriter.flush();
     bufWriter.close();
     outputStream.close();

     if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        StringBuilder response = new StringBuilder();
        BufferedReader input = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()), 8192);
        String strLine = null;
        while ((strLine = input.readLine()) != null) {
           response.append(strLine);
        }
        input.close();
        Object dataReturnedFromServer = new JSONTokener(response.toString()).nextValue();
        // do something
        // with this
     }
} catch (Exception e) {
    // do something
} finally {
    if (httpURLConnection != null) {          
       httpURLConnection.disconnect();// close connection
    }
}