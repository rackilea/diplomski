ObjectMapper objectMapper = new ObjectMapper();
    String jsonInString = "";
    try {
        SimpleModule myModule = new SimpleModule();

        myModule.addSerializer(Date.class, new CustomDateSerializer());
        objectMapper.registerModule(myModule);
        jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objJava);
    } catch (JsonProcessingException e1) {          
        e1.printStackTrace();
    }