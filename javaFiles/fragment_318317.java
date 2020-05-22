Coordinates c = new Coordinates();
c.setRed((byte) 5);

ObjectMapper mapper = new ObjectMapper();
System.out.println("Serialization: " + mapper.writeValueAsString(c));

Coordinates r = mapper.readValue("{\"red\":25}",Coordinates.class);
System.out.println("Deserialization: " + r.getR());