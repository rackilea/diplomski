private static class UserLogin extends AsyncTask<Void, Integer, String> {

    protected String doInBackground(Void... userLogin) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("//domain//file.php?username=UN&password=&PW);

        String result;
        String userID = null;
        try {
            HttpResponse response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
            if (requestBuilder.jSONResultIsSuccess(result))
                userID = requestBuilder.jSONUserID(result);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return userID;
    }