client.get(QUERY_URL + urlString,
    new JsonHttpResponseHandler() {

        @Override
        public void onSuccess(int statusCode, org.apache.http.Header[] headers, JSONObject jsonObject) {
            // Display a "Toast" message
            // to announce your success
            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();

            // 8. For now, just log results
            Log.d("omg android", jsonObject.toString());
        }

        @Override
        public void onFailure(int statusCode, org.apache.http.Header[] headers, Throwable throwable, JSONObject error) {
            // Display a "Toast" message
            // to announce the failure
            Toast.makeText(getApplicationContext(), "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();

            // Log error message
            // to help solve any problems
            Log.e("omg android", statusCode + " " + throwable.getMessage());
        }
    });