public List<Integer> ParseJson(String json, List<Integer> myList) {
    JSONArray jsonArray = null;

    try {
        JSONObject mainJson = new JSONObject(json);
        jsonArray = mainJson.getJSONArray("result");

        List<Integer> reverseListFromJson = new ArrayList<Integer>();
        for (int i = 0; i < jsonArray.length(); i++) {
            reverseListFromJson.add(jsonArray.getInt(i));
        }
        Collections.reverse(reverseListFromJson);

        myList.addAll(reverseListFromJson);
    } catch (JSONException e) {
        e.printStackTrace();
    }

    return myList;
}