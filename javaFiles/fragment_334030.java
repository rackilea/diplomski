public static void connect(String url) {

HttpClient httpclient = new DefaultHttpClient();

AsyncTask<String, Void, Void> connection = new AsyncTask<String, Void, Void>() {

@Override
protected Void doInBackground(String... params) {
// Prepare a request object
HttpGet httpget = new HttpGet(params[0]);

// Execute the request
HttpResponse response;
try {
    list.clear();

    response = httpclient.execute(httpget);
    // Examine the response status
    Log.i("Praeda", response.getStatusLine().toString());

    // Get hold of the response entity
    HttpEntity entity = response.getEntity();
    // If the response does not enclose an entity, there is no need
    // to worry about connection release

    if (entity != null) {

        // A Simple JSON Response Read
        InputStream instream = entity.getContent();
        String result= convertStreamToString(instream);

    // A Simple JSONObject Creation
    //JSONObject json= new JSONObject(result);
    JSONArray jsonArray = new JSONArray(result);


    // A Simple JSONObject Parsing
    for (int i = 0; i < (jsonArray.length()); i++) {
        JSONObject json_obj = jsonArray.getJSONObject(i);
        ResponseHolder rh = new ResponseHolder(json_obj);
        list.add(rh);
    }


     instream.close();
    }
    }
    } catch (ClientProtocolException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

connection.execute(url);
}