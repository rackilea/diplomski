ObjectMapper mapper = new ObjectMapper();
JsonNode rootArray = mapper.readTree(new File("c:\\jsonfile.json")); 

for(JsonNode root : rootArray) {    
    // your code
    ... 
}