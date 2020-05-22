HttpGet httpRequest = new HttpGet(_URL);
HttpClient httpclient = new DefaultHttpClient();
HttpResponse httpresponse = httpclient.execute(httpRequest);
JSONArray response = null;


 try {
    response = new JSONArray(getJSONString(httpresponse));
    } catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }


 for (int i = 0; i < response.length(); i++) {
    try {
    //your values
    String _name=response.getJSONObject(i).getString("NAME");
    }
    } catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
}