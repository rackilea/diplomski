private void jsonParse() {
    try {
        // use jsonobject to parse json with 
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("path to JSON file"));

        JSONObject jsonObject = (JSONObject) obj;

        // get jsonobject by biodata tag
        JSONObject biodata = jsonObject.getJSONObject("biodata");
        // use Iterator to get name 
        Iterator<String> names = biodata.keys();
        // use while loop
        while (names.hasNext()) {
            // get name 
            String name = names.next().toString();
            Log.d("data", "name=" + name);
            // get jsonobject by name tag 
            JSONObject nameJsonObject = biodata.getJSONObject(name);
            // get string 
            String Expertise = nameJsonObject.getString("Expertise");
            String EXperience = nameJsonObject.getString("EXperience");
            Log.d("data", "Experience =" + EXperience);
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
}