private void extractPosition(JSONObject json)
    {
        JSONObject result = json.optJSONArray("results").optJSONObject(0);
        JSONArray address_components = result.optJSONArray("address_components");

        for (int i =0; i<address_components.length();i++)
        {
            String searchKeyword;

            searchKeyword = address_components.optJSONObject(i).optString("types");
            Log.d("test", searchKeyword);

            if (searchKeyword.contains("locality"))
            {
                area.setText(address_components.optJSONObject(i).optString("short_name"));
            }

            if (searchKeyword.contains("administrative_area_level_1"))
            {
                state.setText(address_components.optJSONObject(i).optString("short_name"));
            }
        }

        address.setText(result.optString("formatted_address"));
    }