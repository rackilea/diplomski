JSONObject json = new JSONObject();

    try {
        json.put("dog", "cat");
    } catch (JSONException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

HttpClient localDefaultHttpClient=new DefaultHttpClient();
        HttpPost lotlisting = new HttpPost("http://10.0.2.2/server.php");
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new BasicNameValuePair("json",json.toString()));
        try {
            lotlisting.setEntity(new UrlEncodedFormEntity(localArrayList));
            String str = EntityUtils.toString(localDefaultHttpClient.execute(lotlisting).getEntity());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }