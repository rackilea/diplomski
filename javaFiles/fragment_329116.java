JSONObject jsonObject=new JSONObject();

JSONObject childObject=new JSONObject();
childObject.put("class", "group");
childObject.put("text", "test1");

jsonObject.put("1", childObject);
jsonObject.put("2", childObject);

System.out.println(jsonObject.toString());