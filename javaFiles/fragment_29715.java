String data = "[ {\"pname\":\"7\", \"qty\":\"222\"}, {\"pname\":\"8\", \"qty\":\"5\"}, {\"pname\":\"9\", \"qty\":\"60\"} ]" ;
HashMap<String, String> item = new HashMap<String, String>();
JSONArray jsonArray = new JSONArray(data);
ArrayList<HashMap> mylist = new ArrayList<HashMap>();
if (jsonArray == null) {
    System.out.println("json is empty");
} else {
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        item.put("pname", jsonObject.getString("pname"));
        item.put("qty", jsonObject.getString("qty"));
        mylist.add(item);
    }
}
System.out.println(mylist);