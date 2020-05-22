JsonObject obj = new JsonObject(SERVER_RESPONSE);
try {
     String pictureURL = obj.getString("picture");
    }
catch(JsonException e) {
       // key 'picture' not found
       e.printStackTrace();
}