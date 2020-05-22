@Override
    protected void onPostExecute(String result) {
        json_string = result;
        //this log is displayed with the json_string filled in correctly
        Log.i("onpostexecute","json: " + json_string);

         Intent startChildActivityIntent = new Intent(LoginActivity.this, TaskActivity.class);
         startChildActivityIntent.putExtra("json_data", json_string);
         startActivity(startChildActivityIntent);
    }