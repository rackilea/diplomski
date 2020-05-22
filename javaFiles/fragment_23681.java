String jsonString = "{  \"name\": \"MyCourse\",  \"version\": 12345,  \"chapters\": [    {      \"name\": \"Chapter01\"}]}";
JSONObject jsonObject = new JSONObject(jsonString);
Details details = new Details();
details.setName(jsonObject.get("name"));
details.setVersion(jsonObject.get("version"));
details.setChapters(jsonObject.get("chapters"));