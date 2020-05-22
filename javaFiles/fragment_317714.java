public void parse(String json)  {
       JsonFactory factory = new JsonFactory();

       ObjectMapper mapper = new ObjectMapper(factory);
       JsonNode rootNode = mapper.readTree(json);  

       Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
       while (fieldsIterator.hasNext()) {

           Map.Entry<String,JsonNode> field = fieldsIterator.next();
           System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
       }
}