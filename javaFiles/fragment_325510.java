Map<String,String> apiObject = new HashMap<>();

apiObject.put("user_id","123123");
apiObject.put("name","Bob");

Gson gson = new Gson();
String json = gson.toJson(values);
User user = gson.fromJson(json, User.class);

System.out.println(user);