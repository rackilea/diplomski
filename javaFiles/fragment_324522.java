public void loginMethod(View view) {
    em = email.getText().toString();
    ps = pass.getText().toString();

    if (isConnected()) {
        if (em.contains(" ") || ps.contains(" ")) {
            Toast.makeText(getApplicationContext(), "No spaces are allowed in either field", Toast.LENGTH_SHORT).show();
        } else if (em.matches("") || ps.matches("")) {
            Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            pb.setVisibility(View.VISIBLE);
            new MyAsyncTask().execute(em);

            email.setEnabled(false);
            pass.setEnabled(false);
        }
    } else {
        Toast.makeText(getApplicationContext(), "You are not connected to the internet", Toast.LENGTH_SHORT).show();
    }

}

private class MyAsyncTask extends AsyncTask<String, Integer, Double> {

    @Override
    protected Double doInBackground(String... params) {
        postData(params[0]);
        return null;
    }

    protected void onPostExecute(Double result) {
        if (strResponse.isEmpty()){
            Toast.makeText(getApplicationContext(), "We have no response from the server", Toast.LENGTH_LONG).show();
        } else {
            try {
                jsonArray = new JSONArray(strResponse);
            } catch (JSONException e){
                e.printStackTrace();
            }

            JSONObject json;
            json = null;
            Integer success = 0;

            for (int i=0; i<jsonArray.length(); i++)
            {
                json = null;
                try {
                    json = jsonArray.getJSONObject(i);

                    success = json.getInt("success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            if (success == 1){
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
            } else if (success == 0){
                Toast.makeText(getApplicationContext(), "Incorrect Login Details", Toast.LENGTH_SHORT).show();
            }

        }

        email.setEnabled(true);
        pass.setEnabled(true);

        pb.setVisibility(View.GONE);
    }

    protected void onProgressUpdate(Integer... progress) {
        pb.setProgress(progress[0]);
    }

    public void postData(String s1) {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.gbes.co.za");
        HttpEntity entity;

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("username", em));
            nameValuePairs.add(new BasicNameValuePair("password", ps));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            entity = response.getEntity();
            strResponse = EntityUtils.toString(entity);
        } catch (HttpResponseException e) {
            e.printStackTrace();
        } catch (HttpHostConnectException e){
            e.printStackTrace();
        } catch (ClientProtocolException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}