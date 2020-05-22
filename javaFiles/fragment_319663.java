**JSONArray jar1 = new JSONArray();
jar1.put(0, "ABC");
jar1.put(1, "Son");
jar1.put(2, "Niece");**

**JSONArray jarr = new JSONArray();
jarr.put(0, jar1);**

JSONArray j = new JSONArray();
j.put(0,"session");

JSONObject obj = new JSONObject();          
obj.put("value", jarr);
obj.put("test", j);
obj.put("name","myName");
Log.d("Obj.ToString message: ",obj.toString());
StringEntity entity = new StringEntity(obj.toString());