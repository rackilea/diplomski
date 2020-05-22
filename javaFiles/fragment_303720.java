ObjectMapper mapper = new ObjectMapper(); 

// Convert POJO to Map
Map<String, Object> modelAsMap = 
    mapper.convertValue(model, new TypeReference<Map<String, Object>>() {}); 

// Merge maps
modelAsMap.putAll(attrs);

// Convert Map to POJO
Model modelPatched = mapper.convertValue(modelAsMap, Model.class);