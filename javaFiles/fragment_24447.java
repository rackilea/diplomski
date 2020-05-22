private void Last(final String ID) {
    //final TextView gTextView = (TextView) findViewById(R.id.graph);
    // gTextView.append("  entrato in Data");

    Log.d("ciaoo","sei qui");

    String url = "https://anto-mc.000webhostapp.com/last.php";
    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        final ArrayList<BarEntry> barEntries = new ArrayList<>();

                        ArrayList<String> theDates = new ArrayList<>();
                        Log.d("ciaoo","sei qui2");
                        JSONArray jsonArray = new JSONArray(response);

                        for (int i = 0 ; i < jsonArray.length(); i++) {

                            JSONObject out = jsonArray.getJSONObject(i);
                            Log.d("ciaoo","sei qui2" +""+out);

                            String meteo = out.getString("meteo");
                            disciplina = out.getString("disciplina");
                            risultato = out.getString("risultato");
                            String score = out.getString("punteggio");
                            String tot= out.getString("tot");

                            Log.d("queryris",""+disciplina + "  "+ risultato);
                        }

                        // Set the text here when it is available
                        tExer.setText(disciplina);
                        tRis.setText(risultato);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }, new Response.ErrorListener(){
        @Override
        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    })

    {
        @Override
        protected Map<String, String> getParams()
        {
            Map<String, String>  params = new HashMap<String, String>();
            params.put("userID", ID);

            return params;
        }
    };
    RequestQueue queue = Volley.newRequestQueue(getActivity());
    queue.add(postRequest);
}