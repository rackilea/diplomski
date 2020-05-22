class SendTask extends AsyncTask<String, Void, String> {
@Override
    protected String doInBackground(String... params) {
          // get the message from the message text box
        String msg = msgTextField.getText().toString();  

        // make sure the fields are not empty
        if (msg.length()>0)
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://http://tayyab001.base.pk/kami.php");
         try {
           List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
           nameValuePairs.add(new BasicNameValuePair("id", "12345"));
           nameValuePairs.add(new BasicNameValuePair("message", msg));
           httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
           httpclient.execute(httppost);
           msgTextField.setText(""); // clear text box
         } catch (ClientProtocolException e) {
             // TODO Auto-generated catch block
         } catch (IOException e) {
             // TODO Auto-generated catch block
         }

        }
        else
        {
            // display message if text fields are empty
            Toast.makeText(getBaseContext(),"All field are required",Toast.LENGTH_SHORT).show();
        }
     return null;
}