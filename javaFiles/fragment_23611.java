JSONParser parser = new JSONParser();

JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("test.json"));
JSONArray pages = (JSONArray) jsonObject.get("pages");
if (pages != null) {
    for (Object p : pages) {
        JSONObject page = (JSONObject) p;
        JSONArray subPages = (JSONArray) page.get("subpages");
        if  (subPages != null) {
            for (Object sp : subPages) {
                JSONObject subPage = (JSONObject) sp;
                System.err.println(subPage.get("content"));
            }
        }
    }
}