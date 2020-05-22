//prepare list 
List<Integer> list = new ArrayList<Integer>();
list.add(10);
list.add(20);
...
list.add(100);

JSONArray array = new JSONArray();

for (int i = 0; i < list.size(); i++) {
array.put(list.get(i));
}
JSONObject obj = new JSONObject();

try {
obj.put("values", array);
}catch(JSONException ee){

 }