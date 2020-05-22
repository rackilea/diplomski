JSONArray jsonArray = new JSONArray();

JSONObject jsonObject1= new JSONObject();
JSONObject jsonObject2= new JSONObject();

jsonObject1.put("param1", "value1");
jsonObject1.put("param2", "value2");
jsonArray.add(jsonObject1);


jsonObject2.put("param1", "value3");
jsonObject2.put("param2", "value4");
jsonArray.add(jsonObject2);

System.out.print(jsonArray.toString());