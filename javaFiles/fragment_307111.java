JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, web, null, new Response.Listener<JSONArray>() {

        public void onResponse(JSONArray response) {

            try {
                whichList++;
                lv = (ListView) findViewById(R.id.listView);
                RowItem ri[] = new RowItem[response.length()];


                for (int i = 0; i < response.length(); i++) {

                    JSONObject jsonArray = response.getJSONObject(i).getJSONObject("show");
                    ri[i] = new RowItem(jsonArray.getString("id"), "", "", jsonArray.getJSONObject("image").getString("medium"), jsonArray.getString("name")
                            , jsonArray.getString("summary"));


                }

                ArrayAdapterItem adapter = new ArrayAdapterItem(view.getContext(), R.layout.cf, ri);

                lv.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            Context context = view.getContext();
            Toast.makeText(context, "error to upload " + web, Toast.LENGTH_SHORT).show();
        }
    });
    queue.add(request);

}