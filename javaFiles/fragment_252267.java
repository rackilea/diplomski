ObjectMapper mapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
        .enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

// get an create a new MyObject
MyObject object = new MyObject();

// set the values you want ie the String a and the Map
Map<String, Object> map = new HashMap<String, Object>();
map.put("string", "example string");
map.put("int", 1);
map.put("long", 1l);
map.put("double", 2.0);
// we can also put an array
map.put("intArray", new int[]{1, 2, 3, 10});

// add the map to your object
object.setMap(map);

// set the string a
object.setA("example String 2");

// now we serialize the object
String mySerializedObj = mapper.writeValueAsString(object);

// to deserialize simply do
MyObject myUnserializedObj = mapper.readValue(mySerializedObj, MyObject.class);