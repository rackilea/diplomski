public <T> List<T> getAPI(URL url, Class <T> clazz) throws JsonParseException, JsonMappingException, IOException {   
        // GET 
        ObjectMapper mapper = new ObjectMapper();        
        List<T> objs = mapper.readValue(url, TypeFactory.defaultInstance().constructParametrizedType(ArrayList.class, List.class, clazz));
        return objs;
    }