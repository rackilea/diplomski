public String sendGetMessageValue(String messageId) {
    Map<String, String> response = doInternalModuleApiGet(messageId, 200);
     String fruits = response.get("fruits.grapes");
 JSONObject fruitsJSON= new JSONObject(fruits );
fruitsJSON.getString("grapes");
    return response.get("fruits.grapes");
}