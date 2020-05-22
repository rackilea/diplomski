ObjectMapper mapper = new ObjectMapper(); 

JsonNode rootNode = mapper.readTree(mapper.getJsonFactory()
                        .createJsonParser(response.getEntity(String.class)));

rootNode.findValue("lat").getDoubleValue();