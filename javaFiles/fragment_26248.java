public void saveDB(View v)
{




new insertintoDB().execute();
}  

class insertintoDB extends AsyncTask<String, String, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        /*
         * pDialog = new ProgressDialog(MainActivity.this);
         * pDialog.setMessage("Please wait..."); pDialog.show();
         */
    }

@Override
    protected String doInBackground(String... params) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://illusion.netau.net/android/saveData.php");

        try {
             name= ""+output1.getText().toString();
             batch_no= ""+output2.getText().toString();
             price= ""+output3.getText().toString();
             mfg_dt= ""+output4.getText().toString();
             exp_dt= ""+output5.getText().toString();
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("name",name));
            nameValuePairs.add(new BasicNameValuePair("batch_no",batch_no));
            nameValuePairs.add(new BasicNameValuePair("price",price));
            nameValuePairs.add(new BasicNameValuePair("mfg_dt",mfg_dt));
            nameValuePairs.add(new BasicNameValuePair("exp_dt",exp_dt));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
        return null;
    }

 @Override
    protected void onPostExecute(String s) {
        /*
         * if (pDialog.isShowing()) { pDialog.dismiss();
         * Toast.makeText(getApplication(), "Complete",
         * Toast.LENGTH_LONG).show(); }
         */
    }
 }