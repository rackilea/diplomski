JsonNode array = objectMapper.readValue(sampleString, JsonNode.class);
 for(int i=0;i<array.length;i++){
    JsonNode jsonNode = array.get(i);
    JsonNode idNode = jsonNode.get("id");
    String id = idNode.asText();
    if(id.equals("4")){
        JsonNode firstNameNode = jsonNode.get("firstName");
        String firstName = firstNameNode.asText();
        System.out.println("firstName = " + firstName);
        JsonNode emailNode = jsonNode.get("email");
        String email = emailNode.asText();
        System.out.println("email = " + email);
        break;
    }
 }