public static class AuthUser extends AsyncTask<JSONObject, Void, User>
{
    // [...]

    @Override
    protected User doInBackground(JSONObject... params)
    {
        User user = null;
        String url = ROUTE_USER_AUTH;
        HttpPost httppost = new HttpPost(url);
        HttpClient httpclient = new DefaultHttpClient();
        String UserJSONResponse = null;

        try
        {
            StringEntity m_stringEntity = new StringEntity(params[0].toString());
            // [...]