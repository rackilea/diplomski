public String httpGet(String s, String api_token) {
    String url = s;
    StringBuilder body = new StringBuilder();
    httpclient = new DefaultHttpClient(); // create new httpClient
    HttpGet httpGet = new HttpGet(url); // create new httpGet object
    httpGet.setHeader("X-Access-Token", api_token);

    try {
        response = httpclient.execute(httpGet); // execute httpGet
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == HttpStatus.SC_OK) {
            // System.out.println(statusLine);
            body.append(statusLine + "\n");
            HttpEntity e = response.getEntity();
            String entity = EntityUtils.toString(e);
            body.append(entity);
        } else {
            body.append(statusLine + "\n");
            // System.out.println(statusLine);
        }
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        httpGet.releaseConnection(); // stop connection
    }
    return body.toString(); // return the String
}