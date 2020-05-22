JSONArray jr = new JSONArray("jsonstring");
 for(int i =0 ; i< jr.length();i++)
 {
 JSONObject jb =(JSONObject) jr.get(i);  
 String categoryid = jb.getString("category_id");
 String parent_id = jb.getString("parent_id");
 String name = jb.getString("name");
 }