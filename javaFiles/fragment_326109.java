public static JSONArray getNames(JSONArray inputArray, JSONArray outputArray) {
    for (int i = 0; i < inputArray.length(); i++) {
        JSONObject inputObject = inputArray.getJSONObject(i);

        JSONObject outputObject = new JSONObject();
        outputObject.put("name", inputObject.getString("name"));
        outputArray.put(outputObject);

        if (inputObject.has("children")) {
            JSONArray children = inputObject.getJSONArray("children");
            getNames(children, outputArray);
        }
    }

    return outputArray;
}