JSONObject object1 = new JSONObject();

object1.put("param1", "value1");
object1.put("param2", "param2");

JSONObject innerObject1 = new JSONObject();
innerObject1.put("username", "admin");
innerObject1.put("password", "123");

object1.put("param3",innerObject1);

String jsonStr = object1.toString();