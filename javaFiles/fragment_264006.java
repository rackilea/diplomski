ObjectMapper mapper = new ObjectMapper();
JsonNode parsedJson = mapper.readTree(json); //parse the String or do what you already are doing to deserialize the JSON
ArrayNode outerArray = mapper.createArrayNode(); //your outer array
ObjectNode outerObject = mapper.createObjectNode(); //the object with the "data" array
outerObject.putPOJO("data",parsedJson); 
outerArray.add(outerObject);
System.out.println(outerArray.toString()); //just to confirm everything is working