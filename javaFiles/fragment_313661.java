public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    String input = "{ \"Jan\" : { \"cake\" : [ \"hi\", \".\" ] }, \"obj2\" : { }, \"obj3\" : { } }";
    ObjectMapper mapper = new ObjectMapper();
    HashMap<String, HashMap<String, ArrayList<String>>> map = mapper.readValue(input,
            new TypeReference<HashMap<String, HashMap<String, ArrayList<String>>>>() {
            });
    System.out.println(map.get("Jan").get("cake").get(0));

}