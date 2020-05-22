bouton.setOnClickListener(new View.OnClickListener() {
 public void onClick(View nouveau) {
    new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            httpclient = new DefaultHttpClient();
            httppost = new HttpPost("http://10.0.2.2:8080");

              try {
                  ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                  nameValuePairs.add(new BasicNameValuePair("nom", N));
                  nameValuePairs.add(new BasicNameValuePair("prenom", P));
                  nameValuePairs.add(new BasicNameValuePair("email", E));
                  nameValuePairs.add(new BasicNameValuePair("prevente", B));

                  httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));                  
                  HttpResponse response = httpclient.execute(httppost);
                  Log.i("postData", response.getStatusLine().toString());
              } catch(Exception e) {
                       Log.e("log_tag", "Error:  "+e.toString());
              }  
            return null;
         }
     }.execute();
   }