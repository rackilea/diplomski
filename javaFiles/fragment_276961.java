JSONObject jsonObject = new JSONObject();
jsonObject.accumulate("a", "b");
jsonObject.accumulate("c", "d");
jsonObject.accumulate("c", "e");
jsonObject.accumulate("f", "g");
System.out.println(jsonObject);