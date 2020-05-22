//do some stuff here with your MyObj object

ObjectMapper mapper = new ObjectMapper();
String jsonState1 = mapper.writeValueAsString(MyObj);

//do some stuff here

String jsonState2 = mapper.writeValueAsString(MyObj);