public void syncSQLiteMySQLDB() {

   //i get my json string from sqlite, see the code i posted above about this
        final String json = loadCheckoutDB.composeJSONfromSQLite();

        new Thread() {
            public void run() {
                makeRequest("http://myexample/offline/api", json);
            }
        }.start();

    }

    public void makeRequest(String uri, String json) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("session_id", getapikey());
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = client.execute(httpPost);
            if (response != null) {

                String responseBody = EntityUtils.toString(response.getEntity());
                Log.d("response to sync", responseBody);
                Object jsonObj = new JSONTokener(responseBody).nextValue();
                if (jsonObj instanceof JSONObject) {
                    JSONObject jsonObject = (JSONObject) jsonObj;
                    //further actions on jsonObjects

                } else if (jsonObj instanceof JSONArray) {
                    //further actions on jsonArray
                    JSONArray jsonArray = (JSONArray) jsonObj;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }