ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT); 
try { 
    String json = mapper.writeValueAsString(<your-class-here>);
    System.out.println(json); 
} catch (JsonProcessingException e) { 
    e.printStackTrace(); 
}