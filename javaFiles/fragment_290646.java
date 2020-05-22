public class web_api_get  extends AsyncTask<Object, Object, String> {

     @Override
    public String doInBackground(Object... params) {
        StringBuilder builder = new StringBuilder();

        HttpParams params2 = new BasicHttpParams();
        HttpProtocolParams.setVersion(params2, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params2, "UTF-8");
        params2.setBooleanParameter("http.protocol.expect-continue", false);


        HttpClient client = new DefaultHttpClient(params2); 
        HttpGet httpGet = new HttpGet(params[0]+""); 
        try {       
          HttpResponse response = client.execute(httpGet);
          StatusLine statusLine = response.getStatusLine(); 
          int statusCode = statusLine.getStatusCode();
          if (statusCode == 200) {  
             HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = reader.readLine()) != null) {
              builder.append(line);
            }
          } else {
           // Log.e(ParseJSON.class.toString(), "Failed to download file");
          } 

            } catch (Exception e) { 
            }

        return builder.toString(); 
    } 

}