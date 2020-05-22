JSONObject obj = new JSONObject(result);
for(int i=1;i<=9;i++) {
    JSONArray arr = obj.getJSONArray(""+i);
    for(int j=0;j<arr.length();j++)
        extraction(arr.getJSONObject(j), i);
}