JSONArray jsonArray = new JSONArray(result);
        JSONObject jsonObjWoa = jsonArray.getJSONObject(0);
        JSONArray jsonArrayWoa = jsonObjWoa.getJSONArray("Woa");
        for (int i = 0; i < jsonArrayWoa.length(); ++i) {
            listWoa.add(jsonArrayWoa.getString(i));
        }