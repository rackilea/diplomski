JSONObject main = new JSONObject();
main.put("Command", "CreateNewUser");
JSONObject user = new JSONObject();
user.put("FirstName", "John");
user.put("LastName", "Reese");
main.put("User", user);