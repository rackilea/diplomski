private void LoadTaskSpinner(String url) {
        final ProgressDialog pd=new ProgressDialog(IntTimeLog.this);
        pd.setMessage("Please Wait..Loading Time Log Data");
        pd.setCanceledOnTouchOutside(false);
        pd.show();
        RequestQueue requestQueue=Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
pd.cancel();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if (jsonObject.getInt("success") == 1) {
                        JSONArray jsonArray=jsonObject.getJSONArray("Name");
                        for (int i=0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1=jsonArray.getJSONObject(i);
                            String task=jsonObject1.getString("TaskName");
                            TaskName.add(task);
                        }
                    }
                    taskSpinner.setAdapter(new ArrayAdapter<>(IntTimeLog.this, android.R.layout.simple_spinner_dropdown_item, TaskName));
                } catch (JSONException e) {
                    e.printStackTrace();


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.cancel();
               LoadErrorSpinner(ClientsUrl);
                error.printStackTrace();
            }
        });
        int socketTimeout=30000;
        RetryPolicy policy=new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }