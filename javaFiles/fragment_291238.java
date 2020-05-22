String json1="  { \"name\" :\"ABC\",\"city\":\"XYZ\"}";
String json2="  { \"city\":\"XYZ\", \"name\" :\"ABC\"}";

JsonParser parser = new JsonParser();
JsonElement t2 = parser.parse(json2);
JsonElement t1 = parser.parse(json1); // returns true