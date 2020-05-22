JSONObject jsonObject = new JSONObject("{ 'objs': { 'obj1': 'blah', 'obj2': 'blah' } } ");

JSONObject objs = jsonObject.getJSONObject("objs");

String obj1 = objs.getString("obj1");
String obj2 = objs.getString("obj1");

System.out.println(obj1);
System.out.println(obj2);