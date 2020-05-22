net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
obj.put("jsonStringValue","{\"hello\":\"world\"}");
obj.put("quotedJsonStringValue","\'{\"hello\":\"world\"}\'");
obj.put("naturalStringValue", "\"hello world\"");
System.out.println(obj.toString());
System.out.println(obj.getString("jsonStringValue"));
System.out.println(obj.getString("quotedJsonStringValue"));
System.out.println(obj.getString("naturalStringValue"));