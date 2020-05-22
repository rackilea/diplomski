JSONArray json = new JSONArray("[[{\"msg\":\"hi\",\"uuid\":\"fc8c5dd3-d46c-4945-894d-6160f830d815\"},{\"msg\":\"hihe\",\"uuid\":\"fc8c5dd3-d46c-4945-894d-6160f830d815\"}],14281343855179005,14281349424008427]");
JSONArray arr  = json.getJSONArray(0);

for (int i = 0; i < arr.length(); i++){
    String message = arr.getJSONObject(i).getString("msg");
    String uuid    = arr.getJSONObject(i).getString("uuid");
    System.out.println("message : "+message);
    System.out.println("uuid    : "+uuid);
}