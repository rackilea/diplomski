Map<String, Object> map = mapper.readValue(text, new TypeReference<Map<String, Object>>() {
    });


Map<String, Object> mainMap = (Map<String, Object>) map.get("main");        

System.out.println(mainMap.get("temp"));