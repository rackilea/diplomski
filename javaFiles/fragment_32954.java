// In Java the Arrays must have a size
Os[] o1 = new Os[1];

/* The Array contains only null values by default. You must create 
   objects and assign them to the newly created Array. 
   ( In your example, only one object is created)  */

Os anOs = new  Os();
anOs.os_name = "xyz";
anOs.os_id = 1;

// Assign the object to the Array index 0
o1[0]=anOs;

JSONArray jsArray = new JSONArray(o1);

for (int i = 0; i < jsArray.length(); ++i) {
  JSONObject rec = jsArray.getJSONObject(i);
  int id = rec.getInt("os_id");
  String loc = rec.getString("os_name");
  System.out.println(id+loc);
}