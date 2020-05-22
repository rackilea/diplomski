/**
 * Background Async Task to Get complete User details
 * */
class GetUserDetails extends AsyncTask<String, String, String> {

/**
 * Before starting background thread Show Progress Dialog
 * */
@Override
protected void onPreExecute() {
    super.onPreExecute();
    pDialog = new ProgressDialog(MainActivity.this);
    pDialog.setMessage("Loading details. Please wait...");
    pDialog.setIndeterminate(false);
    pDialog.setCancelable(true);
    pDialog.show();
}

/**
 * Getting User details in background thread
 * */
protected String doInBackground(String... params) {

    // updating UI from Background Thread

    // Check for success tag
    int success;
    try {
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user_ID", "2"));

        // getting User details by making HTTP request
        // Note that User details url will use GET request
        JSONObject json = jsonParser.makeHttpRequest(
                LOGIN_URL, "GET", params);

        // check your log for json response
        Log.d("Single User Details", json.toString());

        // json success tag
        success = json.getInt(TAG_SUCCESS);
        if (success == 1) {
            // successfully received User details
            JSONArray UserObj = json
                    .getJSONArray(TAG_User); // JSON Array

            // get first User object from JSON Array
            final JSONObject User = UserObj.getJSONObject(0);
            runOnUiThread(new Runnable() {
                public void run() {
                    // User with this pid found
                    // Edit Text
                    txtlname = (EditText) findViewById(R.id.editText1);
                    txtfname = (EditText) findViewById(R.id.editText2);

                    // display User data in EditText
                    txtfname.setText(User.getString(TAG_FNAME));
                    txtlname.setText(User.getString(TAG_LNAME));
                }
            });

        }else{
            // User with pid not found
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }


    return null;
}
/**
 * After completing background task Dismiss the progress dialog
 * **/
protected void onPostExecute(String file_url) {
    // dismiss the dialog once got all details
    pDialog.dismiss();
}
}