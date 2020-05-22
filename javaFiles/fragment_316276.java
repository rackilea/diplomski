// send a httpRequest to the url
// and parse the json response to a string
public String sendHttpRequest(String url) {
    try {
        // the HTTP request
        HttpParams p = new BasicHttpParams();
        HttpClient httpclient = new DefaultHttpClient(p);
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("charset", "UTF-8");
        httppost.setHeader("Content-Type", "application/json");

        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        inputStream = entity.getContent();

    } catch (Exception e) {
        Log.e("taghttppost", "" + e.toString());
    }
    // conversion of the httpResponse to a string
    try {
        InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();

        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        inputStream.close();
        result = sb.toString();
        result = new String(sb.toString().getBytes("UTF-8"));

    } catch (Exception e) {
        Log.e("tagconvertstr", "" + e.toString());
    }

    return result;
}