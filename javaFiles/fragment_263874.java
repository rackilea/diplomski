InputStream is = null;
ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("lastupdate", lastupdate)); 

try {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(connection);
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        is = entity.getContent();
        Log.d("HTTP", "HTTP: OK");
    } catch (Exception e) {
        Log.e("HTTP", "Error in http connection " + e.toString());
    }