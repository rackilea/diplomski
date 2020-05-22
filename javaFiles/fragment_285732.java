class A extends AsyncTask<Void, Void, String> {
          protected String doInBackground(Void... params) {
               String result = "";
               try {

                   HttpParams httpParams = new BasicHttpParams();
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httpost = new HttpPost("http://"
                            + serverIp.getText().toString()
                            + "/mobile.php");
                    httpost.setHeader("Accept", "application/json");
                    HttpResponse response = httpclient.execute(httpost);
                    HttpEntity entity = response.getEntity();
                    isr = entity.getContent();
                } catch (Exception e) {
                    Log.e("log.tag",
                            "Error in http connection  " + e.toString());
                    return null;
                    //resultView.setText("Could not connect to Database");
                }
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(isr, "iso=8859-1"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    isr.close();

                    result = sb.toString();
                } catch (Exception e) {
                    Log.e("log.tag",
                            "Error converting result  " + e.toString());
                }

                try {
                    String s = "";
                    JSONArray jArray = new JSONArray(result);
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject json = jArray.getJSONObject(i);
                        s = s + "User :" + json.getString("UserName");
                    }
                    return s;
                } catch (Exception e) {
                    Log.e("log.tag",
                            "Error Parsing Data " + e.toString());
                }
          }
          protected void onPostExecute(String s) {
               if (s == null) {
                    resultView.setText("Could not connect to Database");
               }
               else {
                   resultView.setText(s);
               }

}