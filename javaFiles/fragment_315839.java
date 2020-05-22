import org.json.JSONArray;
    import org.json.JSONObject;

    JSONArray array = jsonObj.getJSONArray("items").getJSONObject(0).getJSONObject("volumeInfo")
            .getJSONArray("industryIdentifiers");

    for (int i = 0; i < array.length(); i++) {
        String type = array.getJSONObject(i).getString("type");
        String identifier = array.getJSONObject(i).getString("identifier");
        System.out.println(type + " identifier : " + identifier);

    }