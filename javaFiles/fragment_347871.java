JSONObject json = new JSONObject();
try {
    json.put("idDevice", id);
    json.put("status", "0");
    json.put("data", "100");
    json.put("address", "1");
    json.put("function", "1");
    json.put("user", "admin");
} catch (JSONException e) {

}
String payload = json.toString(); //"{\"idDevice\":\"value of id\",\"status\":\"0\",‌​\"data\":\"100\",\"a‌​ddress\":\"1\",\"fun‌​ction\":\"1\",\"user‌​\":\"admin\"}"
message.setPayload(payload.getBytes());