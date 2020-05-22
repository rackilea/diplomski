public static void main(String[] args) throws IOException, ParseException {

    JSONParser jsonParser = new JSONParser();

    InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("json.json");
    InputStreamReader reader = new InputStreamReader(is);
    JSONObject result = (JSONObject) jsonParser.parse(reader);
    JSONObject response = (JSONObject) result.get("response");
    JSONObject recs = (JSONObject) response.get("recs");

    boolean hasMore = (Boolean) recs.get("has_more");
    JSONArray objs = (JSONArray) recs.get("objs");
    System.out.println(recs);
    System.out.println("has more " + hasMore);

    Iterator objIter = objs.iterator();
    int i = 0;
    while (objIter.hasNext()) {
        i++;
        System.out.println(String.format("obj %d: %s", i, objIter.next()));
    }

}