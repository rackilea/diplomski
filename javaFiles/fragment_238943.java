ArrayList<Map<String, String>> spinnerArray = new ArrayList<Map<String, String>>();

    for(int i = 0; i<jArray.length();i++){
         JSONObject json_data = jArray.getJSONObject(i);            

         Map<String, String> data = new HashMap<String, String>(2);
         data.put("SessionId", json_data.getString("SessionId"));
         data.put("Title", json_data.getString("Title"));
         spinnerArray.add(data);
         //map.put(json_data.getString("SessionId"), json_data.getString("Title"));
         Button button1 = (Button)findViewById(R.id.Submit);
         button1.setEnabled(true);

    }
      SimpleAdapter adapter = new SimpleAdapter(this, spinnerArray, android.R.layout.two_line_list_item,

               new String[] {"SessionId", "Title"},
               new int[] {android.R.id.text1,
                          android.R.id.text2});

      spinner.setAdapter(adapter);