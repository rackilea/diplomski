Map<Strung, Object> map = new Hashmap<>();
map.put("name", new Integer());
map.put("another name", new String());

String value = (String)map.get("another name");
String value = (String)map.get("name"); // You get error here because integer type stored in map.
// check with 'instanceof' for type if necessary