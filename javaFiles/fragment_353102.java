public JSONObject getJSONFromUrl(JSONObject parm,String url) throws JSONException {


         InputStream is = null;
         JSONObject jObj = null;
         String json = "";
        // Making HTTP request
        try {
            // defaultHttpClient
            /*JSONObject parm = new JSONObject();
            parm.put("agencyId", 27);
            parm.put("caregiverPersonId", 47);*/

        /*  if(!(jObj.isNull("d"))){
                jObj=null;
            }
            */


            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
            HttpEntity body = new StringEntity(parm.toString(), "utf8");
            httpPost.setEntity(body);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();

            is = httpEntity.getContent();          

               /* String response = EntityUtils.toString(httpEntity);
                Log.w("myApp", response);*/

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

     //   JSONObject jObj2 = new JSONObject(json);
        // try parse the string to a JSON object
        try {
             jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        // return JSON String
        return jObj;

    }