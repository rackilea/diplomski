final String json = "{\"name\" : \"john\" , \"worth\" : \"123,456\"}";
final JSONObject jsonObject = new JSONObject(json);
@SuppressWarnings("unchecked")
final Iterator<String> it = jsonObject.keys();
while(it.hasNext()){
    final String nextKey = it.next();
    System.out.println(nextKey + ":" + jsonObject.getString(nextKey));
}