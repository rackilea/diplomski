public void SendDataToServer(final String name, final String email, final String password){
            class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
                @Override
                protected String doInBackground(String... params) {

                    String QuickName = name ;
                    String QuickEmail = email ;
                    String QuickPassword = password;


                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                    nameValuePairs.add(new BasicNameValuePair("nome", QuickName));
                    nameValuePairs.add(new BasicNameValuePair("email", QuickEmail));
                    nameValuePairs.add(new BasicNameValuePair("password", QuickPassword));


                    try {
                        HttpClient httpClient = new DefaultHttpClient();

                        HttpPost httpPost = new HttpPost(Configs.signup);

                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                        HttpResponse response = httpClient.execute(httpPost);

                        HttpEntity entity = response.getEntity();
    StringBuffer result= new StringBuffer();
     BufferedReader in = new BufferedReader(
                        new InputStreamReader(entity.getContent()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    result.append(inputLine);
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result.toString();
                }

                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);


                    Log.d(result, "Value");


                    try {

                        JSONObject jo = new JSONObject(result);
                        String status = jo.optString("status");


                            if (status.equals("0")) {
                                Toast.makeText(Signup.this, "Username already exists", Toast.LENGTH_LONG).show();

                            } else if (status.equals("1")) {
                                Intent intent = new Intent(Signup.this, Login.class);
                                startActivity(intent);

                                Toast.makeText(Signup.this, "Registered successfully", Toast.LENGTH_LONG).show();
                                Toast.makeText(Signup.this, "Verify your email adress in email received", Toast.LENGTH_SHORT).show();
                                finish();
                            } else if (status.equals("2")) {
                                Toast.makeText(Signup.this, "Failed to Signup", Toast.LENGTH_LONG).show();
                            }
                            //}

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
            SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
            sendPostReqAsyncTask.execute(name, email, password);
        }