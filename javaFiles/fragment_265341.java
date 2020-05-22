private static final String TAG = YourActivity.class.getSimpleName();
StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                Log.e(TAG, "Successfully signed in : " + response.toString());
            }
        }, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "Error at sign in : " + error.getMessage());
    }
}) {
    @Override
    public HashMap<String, String> getParams() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email_mobile", username);
        params.put("passwd", password);
        params.put("m", "student");
        params.put("uc", "signin");
        params.put("signin", "Sign+In");
        return params;
    }
};