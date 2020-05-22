public class SendRequestAsyncTask extends AsyncTask <Void, String, String> {

@Override
protected void onPreExecute() {
    // TODO Auto-generated method stub
    super.onPreExecute();
    //runs in ui thread
}

@Override
protected String doInBackground(Void... params) {
    // TODO Auto-generated method stub
    String strReturn = "";

    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("myscript.php");

    try {
        // Add your data
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("request", "12345"));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        // Execute HTTP Post Request
        HttpResponse response = httpclient.execute(httppost);

        // writing response to log
        HttpEntity resEntity = response.getEntity();

        if (resEntity != null) {

            String responseStr = EntityUtils.toString(resEntity).trim();
            Log.v(TAG, "Response: " +  responseStr);

            String[] parts = responseStr.split(":");
            parts[1] = parts[1].replace("\"", "");
            parts[1] = parts[1].replace("}", "");

            strReturn = parts[1];
        }

    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
    } catch (IOException e) {
        // TODO Auto-generated catch block
    }

    return strReturn;
}

@Override
protected void onPostExecute(String result) {
    // TODO Auto-generated method stub
    super.onPostExecute(result);
    //runs in ui thread you can update the layout here

    if (result.equals("01")){
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
    } else {
        Log.v(TAG, "No success: " + parts[1]);
    }
}
}