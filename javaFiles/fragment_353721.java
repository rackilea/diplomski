JSONObject jsonObject = new JSONObject(PaListContent);
JSONArray myResponse = jsonObject.getJSONArray("elements");
//JSONArray tsmresponse = (JSONArray) myResponse.get("listTsm");

ArrayList<String> list = new ArrayList<String>();

for(int i=0; i<myResponse.length(); i++){
    list.add(myResponse.getJSONObject(i).getString("name"));
}

System.out.println(list);