public void testJackson() throws IOException {  
    ObjectMapper mapper = new ObjectMapper(); 
    File from = new File("albumnList.txt"); 
    TypeReference<HashMap<String,Object>> typeRef 
            = new TypeReference<HashMap<String,Object>>() {};

    HashMap<String,Object> o = mapper.readValue(from, typeRef); 
    System.out.println("Got " + o); 
}