JSONObject outerObject = new JSONObject(json);
JSONObject innerObject = outerObject.getJSONObject("highlighting");

for(Object key : innerObject.keySet()) {         
    JSONObject o =innerObject.getJSONObject(key.toString());
    String[] elementNames = JSONObject.getNames(o);
    System.out.printf("%s >> %d ELEMENT(S) IN CURRENT OBJECT:\n", key, elementNames.length);
    for (String elementName : elementNames) {
        System.out.println(elementName);
        String value = o.get(elementName).toString();
        System.out.printf("name=%s, value=%s\n", elementName, value);
    }
    System.out.println();    
}