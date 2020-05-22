try {
        List<String> filtered = new ArrayList<>();
        JSONArray ary = new JSONArray(/* your json here */);

        for (int i = 0; i < ary.length(); ++i) {
            JSONObject obj = ary.getJSONObject(i);
            String id = obj.getString("id_estado");
            if (id.equals("1")) {
                filtered.add(obj.getString("tienda"));
            }
        }
    } catch (JSONException e) {
        // handle exception
    }