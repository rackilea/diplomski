JSONArray  pages =  new JSONArray(response_str);
  for (int i = 0; i < pages.length(); ++i) {
      JSONObject rec = pages.getJSONObject(i);
      JSONArray jsonPage =rec.getJSONArray("station");
      // get JSONObject
      JSONObject jsonstation =jsonPage.getJSONObject(0);
      String name= jsonstation.getString("name");
      System.out.println(name);
   }