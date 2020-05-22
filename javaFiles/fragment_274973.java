String parse = "{\"Person Id\":\"test\",\"Last Name\": \"lname\",\"First Name\":\"fname\"}";
try {
    JSONObject jsonObject   =   new JSONObject(parse);
    String id = jsonObject.getString("Person Id");
    System.out.println("id="+id);
    System.out.println("lname="+jsonObject.getString("Last Name"));
    System.out.println("fname="+jsonObject.getString("First Name"));
} catch (JSONException e) {
    e.printStackTrace();
}