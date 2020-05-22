String temp = charset.decode(inBuff).toString();

JSONObject obj = new JSONObject(temp);

String action = obj.getString("action");

System.out.println(action); //