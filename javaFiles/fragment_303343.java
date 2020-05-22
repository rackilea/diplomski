@FXML
void signUp(ActionEvent event) {
    PrintWriter writer = MainGui.client.getWriter();

    User user = new User();
    user.setName(userNameField.getText());
    user.setPassword(pwField.getText());
    Gson gson = new GsonBuilder().create();
    String json = gson.toJson(user);
    JsonParser p = new JsonParser();
    JsonObject obj = p.parse(json).getAsJsonObject();

    JsonObject jsonAction = new JsonObject();
    jsonAction.addProperty("type", "registration");

    JsonObject sendMsg = new JsonObject();
    sendMsg.add("action", jsonAction);
    sendMsg.add("user", obj);
    writer.println(sendMsg.toString());
    writer.flush();
}