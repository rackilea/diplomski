Status instance = new Status();
String jsonString = null;

instance.setDone(true);
ObjectMapper mapper = new ObjectMapper();

jsonString = mapper.writeValueAsString(instance);