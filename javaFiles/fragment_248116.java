JSONArray array = new JSONArray(s);
int length = array.length();
for (int i = 0; i < length; i++) {
    JSONObject o = array.getJSONObject(i);
    System.out.println(o);
}