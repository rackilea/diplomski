Object keyObjects = new Gson().fromJson(ntw_Ports_obj, Object.class);
List keys = new ArrayList();

/** for the given json there is a one json object within the 'Ports' so the 'keyObjects' will be the 'Map'**/
if (keyObjects instanceof Map) {
    Map map = (Map) keyObjects;
    keys.addAll(map.keySet());
    /**
     * keys is a List it may contain more than 1 value, but for the given
     * json it will contain only one value
     **/
    String key = (String) keys.get(0);
    JsonArray jArray = (JsonArray) ntw_Ports_obj.get(key);
    System.out.println(jArray);
}