ObjectMapper mapper = new ObjectMapper();

// Changed the spelling from "cheked" to "checked"
String json = "{\"timeLeft\": \"10:00\", \"checked\": true}";
final TimeLeftPojo timeLeftPojo = mapper.readValue(json, TimeLeftPojo.class);
System.out.println(timeLeftPojo.toMillisecondOfDay());