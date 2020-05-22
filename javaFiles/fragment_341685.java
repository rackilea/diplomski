User downloaded = User.findByName("me");

User json = new Gson().fromJson("{\"id\": 1, \"username\": \"me\", ... \"}", User.class);

User manually = new User();
manually.username = "me";
manually.email = "me@example.org";
// ...