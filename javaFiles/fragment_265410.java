private String test(String uname, String pass) {
    try {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user_email", uname);
        jsonObject.put("user_password", pass);
        jsonArray.put(jsonObject);
        return jsonArray.toString();
    } catch (Exception e) {
        e.printStackTrace();
        return "";
    }
}