// This is your string.
String myJsonString = "[{\"id\":1,\"name\":\"hamid\"},{\"id\":2,\"name\":\"mohamad\"},{\"id\":3,\"name\":\"ali\"},{\"id\":4,\"name\":\"john\"},{\"id\":5,\"name\":\"smith\"}]";

// Create new Gson object.
Gson gson = new Gson();

// Convert
List<MyUser> userList = gson.fromJson(myJsonString, new TypeToken<List<MyUser>>() {
    }.getType());