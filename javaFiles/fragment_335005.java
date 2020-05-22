private class NetworkTask extends AsyncTask<Void, Void, Void>{
         @Override
         protected Void doInBackground(Void... arg0) {
             HttpClient httpClient = new DefaultHttpClient();
             HttpPost httpPost = new HttpPost("http://www.babyschuh.de/malte/androidApp/getAllDaten.php");        //URL eintragen!!!

             List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
             nameValuePair.add(new BasicNameValuePair("name", "Malte Schlichting"));
             nameValuePair.add(new BasicNameValuePair("raum", "12"));

             // Encoding the POST parameters
             try {
                 httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
             } catch (UnsupportedEncodingException e) {
                 e.printStackTrace();
             }

             // Making fHTTP Request
             try {
                 HttpResponse response = httpClient.execute(httpPost);

                 Log.d("Http Response", response.toString());
             } catch (ClientProtocolException e) {
                 e.printStackTrace();
             } catch ( IOException e) {
                 e.printStackTrace();
             }
         }
 }