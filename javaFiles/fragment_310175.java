public void signup() {
    String name = new String();
    String fname = _fnameText.getText().toString();
    String lname = _lnameText.getText().toString();
    String password = _passwordText.getText().toString();
    // TODO: Implement your own signup logic here.
    if(name!=null && fname!=null && lname!=null && password!=null) {
        if (isConnected()) {
            if (validate()) {
                _signupButton.setEnabled(false);
                jsonSignup = new JSON_Signup(SignupActivity.this, "http://teroject.com/api/android.php", name, password);
                jsonSignup.valuesForServer.add(new BasicNameValuePair("api_key", "teroapi_php_java_1395"));
                jsonSignup.valuesForServer.add(new BasicNameValuePair("api_function", "register"));
                jsonSignup.valuesForServer.add(new BasicNameValuePair("username", name));
                jsonSignup.valuesForServer.add(new BasicNameValuePair("password", password));
                jsonSignup.valuesForServer.add(new BasicNameValuePair("fname", fname));
                jsonSignup.valuesForServer.add(new BasicNameValuePair("lname", lname));
                jsonSignup.execute();
            }
        }
    }else {
        Toast.makeText(getApplicationContext(), "لطفا از کاراکتر های مجاز استفاده کنید", Toast.LENGTH_SHORT).show();
    }

}

public JSON_Signup(Context context, String url, String username, String password){
        this.context=context;
        this.url=url;
        this.username=username;
        this.password=password;
        valuesForServer=new List<BasicNameValuePair>();
        progressDialog=new ProgressDialog(this.context);
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setMessage("در حال ثبت نام لطفا صبر کنید....");
        progressDialog.show();
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface arg0) {
                JSON_Signup.this.cancel(true);
            }
        });
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            // Set up HTTP post
            // HttpClient is more then less deprecated. Need to change to URLConnection
            HttpParams httpParameters = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParameters, 20000);
            HttpConnectionParams.setSoTimeout(httpParameters, 20000);
            DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(valuesForServer, "utf-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();

            StatusLine statusLine = httpResponse.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                // Read content & Log
                inputStream = httpEntity.getContent();
            }else{
                return null;
            }
        }catch (NetworkOnMainThreadException e7){
            Log.i("Network on Main Thread", e7 + "");
            e7.printStackTrace();
            return null;
        } catch(SocketTimeoutException e6){
            Log.i("Connection Timeout", e6 + "");
            e6.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e1) {
            Log.i("Unsupported Encoding",e1+"");
            e1.printStackTrace();
            return null;
        } catch (ClientProtocolException e2) {
            Log.i("Client Protocol", e2 + "");
            e2.printStackTrace();
            return null;
        } catch (IllegalStateException e3) {
            Log.i("Illegal State", e3 + "");
            e3.printStackTrace();
            return null;
        } catch (IOException e4) {
            Log.i("Exception", e4 + "");
            e4.printStackTrace();
            return null;
        }
        // Convert response to string using String Builder
        if(inputStream!=null) {
            try {
                BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"), 8);
                StringBuilder sBuilder = new StringBuilder();

                String line = null;
                while ((line = bReader.readLine()) != null) {
                    sBuilder.append(line + "\n");
                }

                inputStream.close();
                result = sBuilder.toString();

            } catch (Exception e) {
                Log.i("Exception", e + "");
                return null;
            }
        }else {
            return null;
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            //parse JSON data
            try {
                mainFile = new JSONObject(result);
                success = mainFile.getString("success");
                message = mainFile.getString("message");
                if (success.equals("1")) {
                    _signupButton.setEnabled(true);
                    Toast.makeText(this.context, message, Toast.LENGTH_LONG).show();
                    if (isConnected()) {
                        JSON json = new JSON(this.context, "http://teroject.com/api/android.php", this.username, this.password);
                        json.valuesForServer.add(new BasicNameValuePair("api_key", "teroapi_php_java_1395"));
                        json.valuesForServer.add(new BasicNameValuePair("api_function", "login"));
                        json.valuesForServer.add(new BasicNameValuePair("username", this.username));
                        json.valuesForServer.add(new BasicNameValuePair("password", this.password));
                        json.execute();
                    }
                } else if (success.equals("0")) {
                    Toast.makeText(this.context, message, Toast.LENGTH_LONG).show();
                    _signupButton.setEnabled(true);
                }
                this.progressDialog.dismiss();
            } catch (JSONException e) {
                Toast.makeText(this.context, e + "", Toast.LENGTH_SHORT).show();
                _signupButton.setEnabled(true);
                this.progressDialog.dismiss();
            }
        }else {
            _signupButton.setEnabled(true);
            progressDialog.dismiss();
            Toast.makeText(this.context,"خطا در برقراری ارتباط",Toast.LENGTH_LONG).show();
        }
    }
}