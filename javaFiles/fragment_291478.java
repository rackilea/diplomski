String jsonString="[{\"tag\":\"rat\",\"score\":0.7973},{\"tag\":\"lion\",\"score\":0.7184},{\"tag\":\"dog\",\"score\":0.2396},{\"tag\":\"woof\",\"score\":0.1944},{\"tag\":\"cat\",\"score\":0.1157}]";
TypeReference<ArrayList<Map<String, String>>> typeRef = new TypeReference<ArrayList<Map<String, String>>>() {};
ObjectMapper mapper = new ObjectMapper();
try {
    ArrayList<Map<String, String>> data = mapper.readValue(jsonString, typeRef);
    for (Map<String, String> map : data) {
        System.out.println(map.get("tag"));
    }
} catch (Exception e) {
    System.out.println("There might be some issue with the JSON string");
}