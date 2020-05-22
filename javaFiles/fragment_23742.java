JsonParser parser=new JsonParser();

JsonObject object=(JsonObject)parser.parse("{ 'objs': { 'obj1': 'blah', 'obj2': 'blah' } } ");

JsonObject objs2 = object.get("objs").getAsJsonObject();

String value1=objs2.get("obj1").getAsString();
String value2=objs2.get("obj2").getAsString();

System.out.println(value1);
System.out.println(value2);