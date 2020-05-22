public static JSONObject read(String url, String unp){

    System.out.println("Connecting to service URL : "+url);
    InputStream is = null;
    String result = "";
    // http post
    try {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        String encoded_login = Base64.encodeToString(unp.getBytes(), Base64.NO_WRAP);
        httppost.setHeader(new BasicHeader("Authorization", "Basic "+encoded_login));
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        is = entity.getContent();

    } catch (Exception e) {
        e.printStackTrace();
    }

    // convert response to string
    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        is.close();
        result = sb.toString();

    } catch (Exception e) {
        e.printStackTrace();
    }

    JSONObject json = null;
    try {
        json = new JSONObject(result);
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return json;
}

}