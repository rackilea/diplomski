byte[] inputBytes = Files.readAllBytes(Paths.get("test.json"));
String inputText = new String(inputBytes, StandardCharsets.US_ASCII);
JSONObject inputJson = new JSONObject(inputText);
JSONObject outputJson = new JSONObject();
for (Object monthObj : inputJson.getJSONArray("Roles")) {
    JSONObject monthJson = (JSONObject) monthObj;
    for (String monthName : monthJson.keySet()) {
        for (Object regionObj : monthJson.getJSONArray(monthName)) {
            JSONObject regionJson = (JSONObject) regionObj;
            for (String regionCode : regionJson.keySet()) {
                for (Object roleObj : regionJson.getJSONArray(regionCode)) {
                    String roleName = (String) roleObj;
                    JSONObject role = outputJson.optJSONObject(roleName);
                    if (role == null)
                        outputJson.put(roleName, role = new JSONObject());
                    JSONArray region = role.optJSONArray(regionCode);
                    if (region == null)
                        role.put(regionCode, region = new JSONArray());
                    region.put(monthName);
                }
            }
        }
    }
}
System.out.println(outputJson.toString(3));