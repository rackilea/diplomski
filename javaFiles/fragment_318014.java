try {
    HttpClient client = new DefaultHttpClient();  
    String postURL = "http://somepostaddress.com";
    HttpPost post = new HttpPost(postURL); 
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user", "kris"));
        params.add(new BasicNameValuePair("pass", "xyz"));
        UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params,HTTP.UTF_8);
        post.setEntity(ent);
        HttpResponse responsePOST = client.execute(post);  
        HttpEntity resEntity = responsePOST.getEntity();  
        if (resEntity != null) {    
            Log.i("RESPONSE",EntityUtils.toString(resEntity));
        }
} catch (Exception e) {
    e.printStackTrace();
}