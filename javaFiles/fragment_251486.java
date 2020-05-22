@Override
    protected Boolean doInBackground(Void... params) {
        HttpClient httpclient = new DefaultHttpClient();

        CookieStore cookieStore = new BasicCookieStore();
        HttpContext localContext = new BasicHttpContext();
        localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

        HttpPost httppost = new HttpPost("http://testsite.com/login");

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("userid", "john"));
            nameValuePairs.add(new BasicNameValuePair("password", "test"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpclient.execute(httppost, localContext);
            String TAG = "com.imtins.worryfree";
            String responseAsText = EntityUtils.toString(response.getEntity());

            Log.d(TAG, "Response from server: " + responseAsText.toString());

        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }