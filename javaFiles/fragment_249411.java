public void testGson() {
    String input = "{\"test\": 123, \"nested\": {\"nested-1\": 1, \"nested-2\": 2}}";
    LinkedHashMap<String, Object> json = new Gson().fromJson(input, LinkedHashMap.class);

    // iterating
    for(Map.Entry<String, Object> entry : json.entrySet()){
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

    // testing values 
    System.out.println(json.get("test")); // should be 123
    Map<String, Object> nested = (Map<String, Object>) json.get("nested");
    System.out.println(nested.get("nested-1")); // should be 1
    System.out.println(nested.get("nested-2")); // should be 2
}