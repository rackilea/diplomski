String jsonString = "{\n" + 
            "     \"filetype\": {\n" + 
            "        \"cell\": \"value\"\n" + 
            "     },\n" + 
            "     \"fileType2\": {\n" + 
            "        \"cell2\": \"value2\"}\n" + 
            " }";

    Map<String, Map<String, String>> map;
    ObjectMapper mapper = new ObjectMapper();

    try {
        map = mapper.readValue(
            jsonString,
            new TypeReference<Map<String, Map<String, String>>>(){}
        );
        System.out.println(map);
    } catch (Exception e) {
        e.printStackTrace();
    }