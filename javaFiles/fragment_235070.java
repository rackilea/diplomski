// private void insertToDatabase(String id,String unique){
class SendPostReqAsyncTaskk extends AsyncTask<String, String, String>  {
    @Override
    protected String doInBackground(String... params) {
        String paramUsername = params[0];
       String paramAddress = params[1];

        String id = idd.getText().toString();
        String unique = UniqueId.getText().toString();

        String json = "";
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("id", id));
        nameValuePairs.add(new BasicNameValuePair("unique", unique));

        // getting JSON Object
        // Note that create product url accepts POST method

       try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("MY_URL");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpClient.execute(httpPost);
            json = EntityUtils.toString(response.getEntity());


        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }
        return json;


    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if(result.equals("\"success\"")){
         // Update your Button here
        } else {

        } 

    }
}