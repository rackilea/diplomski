//example json string
String json = "{paramsArray: [\"first\", 100],"
        + "paramsObj: {one: \"two\", three: \"four\"},"
        + "paramsStr: \"some string\"}";

JSONParser parser = new JSONParser();

Object obj = parser.parse(json);
JSONObject jsonObj = (JSONObject) obj;
System.out.println(jsonObj.get("paramsStr"));

JsonObject jo = jsonObj.get("paramsObj");
System.out.println(jo.get("three"));
// output will be 'four'