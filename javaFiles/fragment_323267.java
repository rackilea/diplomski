Map<String, List<String>> osMap = new HashMap<String, List<String>>();
    osMap.put("OS", new ArrayList<String>());

    Map<String, Map<String, List<String>>> apiNameMap = 
        new HashMap<String, Map<String, List<String>>>();
    apiNameMap.put("api_name", new HashMap<String, List<String>>());

    JSONArray ja = (JSONArray) JSONValue.parse(JSON_STRING);
    for (Object obj : ja) {
        JSONObject jsonObj = (JSONObject) obj;
        String os = (String) jsonObj.get("os");
        String apiName = (String) jsonObj.get("api_name");
        String longVersion = (String) jsonObj.get("long_version");

        // OS
        if (!osMap.get("OS").contains(os)) {
            osMap.get("OS").add(os);
        }

        // API
        if (!apiNameMap.get("api_name").containsKey(apiName)) {
            apiNameMap.get("api_name")
                    .put(apiName, new ArrayList<String>());
        }
        apiNameMap.get("api_name").get(apiName).add(longVersion);

    }

    System.out.println(JSONValue.toJSONString(osMap));
    System.out.println(JSONValue.toJSONString(apiNameMap));