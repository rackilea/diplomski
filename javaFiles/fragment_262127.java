JSONObject jsonObject = new JSONObject(); 
jsonObject.put("empt_id", 1017); 
jsonObject.put("emp_name", "karthik"); 

HashMap<String, JSONObject> jsonObjectStore = new HashMap<String, JSONObject>(); 
jsonObjectStore.put("myJsonObject", jsonObject); 

HashMap<JSONObject, String> jsonObjectStore2 = new HashMap<JSONObject, String>();
jsonObjectStore2.put(jsonObject, "myJson");