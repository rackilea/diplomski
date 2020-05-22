@Override
    protected String doInBackground(String... params) {
        String method = params[0];
        if(method.equals("register"))
        {
            try {
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                //....
                // return string builder as normal string.
                return  stringBuilder.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;            //YOU ARE RETURNING NULL. CHECK WHETHER params[0] is "register"
    }
    //....
    @Override
    protected void onPostExecute(String json) { //json might be null. Try to print it using log.debug()
        try {
            progressDialog.dismiss();
            JSONObject jsonObject = new JSONObject(json);   //This might throw exception
            //...
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }