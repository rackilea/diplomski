ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
   JSONParser jParser = new JSONParser(); 
   JSONArray json = jParser.getJSONFromUrl(url);
   try { for (int i=0; i< json.length(); i++) {
    JSONObject details = json.getJSONObject(i);
    String id = details.getString("Id");
    String name = details.getString("Name");
    HashMap<String, String> map = new HashMap<String, String>(); 
   map.put(TAG_ID, id); map.put(TAG_NAME, name);


    contactList.add(map)
    JSONArray ja=details.getJSONArray("Available");

        for (int i = 0; i < ja.length(); i++) {
            JSONObject jobj=ja.getJSONObject(i);
           String a =jobj.getString("date");
          String b   =jobj.getJSONArray("timings").tostring;
    HashMap<String, String> map2 = new HashMap<String, String>(); 
   map2.put("a", a); map2.put("b", b);
    contactList.add(map2)

        }

     }