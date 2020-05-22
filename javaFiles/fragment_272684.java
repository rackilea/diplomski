class Response {
  String status;
  String data;
}

class Other {
  String status;    
  ArrayList<SomeOtherType> data;
}

ObjectMapper mapper = new ObjectMapper();
Other rspns = mapper.readValue(<theJSONStrHere>, Other.class);