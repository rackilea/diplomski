private static String getData(String name, int age, String street, String line) throws JSONException {
    JSONObject jsonObject = new JSONObject("{  name : VARIABLE1,  age : VARIABLE2,  address : { street : VARIABLE3,    line : VARIABLE4  }}");
    JSONObject address = (JSONObject) jsonObject.get("address");
    jsonObject.put("name", name);
    jsonObject.put("age", age);
    address.put("street", street);
    address.put("line", line);
    return jsonObject.toString();
}