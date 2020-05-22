private void insertToDatabase(String name, String pass) {
class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
@Override
protected String doInBackground(String... params) {
   String name = params[0];
   String pass = params[1];
   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
   nameValuePairs.add(new BasicNameValuePair("name", name));
   nameValuePairs.add(new BasicNameValuePair("pass", pass));
   try {
    HttpClient httpClient = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(                   "http://calisapp.esy.es/register.php");
    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    HttpResponse response = httpClient.execute(httpPost);
    InputStream entity = response.getEntity().getContent();
    InputStreamReader inputStream = new InputStreamReader(entity);
    BufferedReader bufferedReader = new BufferedReader(inputStream);
    StringBuilder stringBuilder = new StringBuilder();
    String bufferedStrChunk = null;
    while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
        stringBuilder.append(bufferedStrChunk);
    }
    return stringBuilder.toString();
  } catch (ClientProtocolException e) {
  } catch (IOException e) {
  }
    return "";
}

    @Override
    protected void onPostExecute(String result) {
      super.onPostExecute(result);
      try {
       JSONObject jo = new JSONObject(result);
       String status = jo.getString("status");
       if (status.equals("0")) {
         editTextName.requestFocus();
         editTextName.setError("Username already exists.");
       } else if (status.equals("1")) {
         Intent intent = new Intent(Register.this, MainActivity.class);
         startActivity(intent);
         Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_LONG).show();
         finish();
       }else if (status.equals("2")) {
         // failed to register
       }
     } catch (JSONException e) {
       e.printStackTrace();
     }
 }
}
 SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
 sendPostReqAsyncTask.execute(name, pass);