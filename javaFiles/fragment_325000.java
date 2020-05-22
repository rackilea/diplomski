class AttemptLogin extends AsyncTask<String, String, JSONObject>
{
    String username;
    String password;

    public AttemptLogin(String username, String password){
        this.username = username;
        this.password = password;
    }

    protected JSONObject doInBackground(String... args)
    {
        JSONObject json;
        try {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", this.username));
            params.add(new BasicNameValuePair("password", this.password));

            Log.d("request!", "starting");
            // getting product details by making HTTP request
            JSONObject json = jsonParser.makeHttpRequest(
                    LOGIN_URL, "POST", params);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    protected void onPostExecute(JSONObject result)
    {
       // check your log for json response
       Log.d("Login attempt", json.toString());
    }
}