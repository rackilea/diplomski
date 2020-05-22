JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jsonObject) {
                hidePDialog();
                System.out.println("JsonObject++===---"+jsonObject);
                try {
                    JSONArray response = jsonObject.getJSONArray("objects");

                    for(int i=0; i <response.length(); i++){
                        JSONObject obj = response.getJSONObject(i);
                        CaseStudy reference = new CaseStudy();
                        reference.setTitle(obj.getString("title"));
                        reference.setThumbnailUrl(obj.getString("image_path"));
                        reference.setPostcode(obj.getString("postcode"));


                        // adding movie to movies array
                        caseList.add(reference);
                    }

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    System.out.println("error");
                    e.printStackTrace();
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError arg0) {
                hidePDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, TAG);