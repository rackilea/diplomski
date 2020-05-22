public String getPostRequest(String url, String user, String pass) {
    HttpClient postClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(url);
    HttpResponse response;

    try {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("user", user));
        nameValuePairs.add(new BasicNameValuePair("pass", pass));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        response = postClient.execute(httpPost);

        if(response.getStatusLine().getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream instream = entity.getContent();  
                String result = convertStreamToString(instream);
                instream.close();
                return result; // here is a string of the result!!!
            }
        }
    } catch (Exception e) {}

    return null; // if it gets here, something wrong happens with the connection
}

private String convertStreamToString(InputStream is) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return sb.toString();
}