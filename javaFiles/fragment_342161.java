//array list
     List<String> your_array_list = new ArrayList<String>();
     try{
    JSONArray jArray = new JSONArray(result);
    int jArrLeng = jArray.length();
    for(int i=0; i<jArrLeng;i++){
        JSONObject json_data= jArray.getJSONObject(i);

        your_array_list.add(json_data.getString("ID") + "\n");
        your_array_list.add(json_data.getString("heading") + "\n");
        your_array_list.add(json_data.getString("rank") + "\n:");

      }
    resultLV.setAdapter(new ArrayAdapter<String>(SearchPage.this, android.R.layout.simple_list_item_1,your_array_list));