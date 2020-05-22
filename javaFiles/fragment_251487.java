// replace XXX below with correct URL
        httppost = new HttpPost("http://testsite.com/XXXXXX");

        try {
            // set entities here ...

            HttpResponse response = httpclient.execute(httppost, localContext);
            String TAG = "com.imtins.worryfree";
            String responseAsText = EntityUtils.toString(response.getEntity());

            Log.d(TAG, "Response from server: " + responseAsText.toString());

        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }