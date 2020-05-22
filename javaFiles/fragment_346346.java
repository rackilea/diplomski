JSONObject json = new JSONObject(response);

    JSONArray jsonarray = json.getJSONArray("datas");

    for (int i = 0; i < jsonarray.length(); i++) {
         JSONObject c = jsonarray.getJSONObject(i);

         //here you get by json key
         String id = c.getString("com_branch_id");

    }