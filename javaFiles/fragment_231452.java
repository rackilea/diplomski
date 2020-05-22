ProgressDialog progressDialog; // define globally

 public void getLocations(){   //call this method onCreate or on OnClickEvent

    progressDialog = new ProgressDialog(getActivity());
    progressDialog.setMessage("Feteching....");
    progressDialog.setCancelable(false);
    progressDialog.show();

    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

    StringRequest request = new StringRequest(Request.Method.GET, "YOUR URL", new Response.Listener<String>() { //you can change here POST/GET
        @Override
        public void onResponse(String response) {
            progressDialog.dismiss();
            System.out.println("Response : " + response);
            try {

                 JSONObject jsonResponse = new JSONObject(response);

                  JSONArray locations = jsonResponse.getJSONArray("LOCATIONS");
                  for (int i = 0; i < locations.length(); i++) {
                  JSONObject jsonObject = locations.getJSONObject(i);

               String name = jSONObject.getString("name");
                String lat = jSONObject.getString("lat");
                String lng = jSONObject.getString("lng");
                 System.out.println("LOCATIONS : " + name +"," + lat + "," + lng);

               // check this print in logcats

                 }
               } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println("VolloError " + error);
            progressDialog.dismiss();
            Toast.makeText(YourActivity.this, "Network Connection Error...!!!", Toast.LENGTH_SHORT).show();
        }
    }) {
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<String, String>();

            // use params when you are using POST method

            return params;
        }

    };

    request.setRetryPolicy(new RetryPolicy() {
        @Override
        public int getCurrentTimeout() {
            return 50000;
        }

        @Override
        public int getCurrentRetryCount() {
            return 50000;
        }

        @Override
        public void retry(VolleyError error) throws VolleyError {

        }
    });
    queue.add(request);
}