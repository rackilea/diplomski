ObjectMapper mapper = new ObjectMapper();
Map<Object, Object> parsedJSON =  mapper.readValue(incomingJSON,
                        mapper.getTypeFactory().constructMapType(
                          LinkedHashMap.class,
                          Object.class, 
                          Object.class));