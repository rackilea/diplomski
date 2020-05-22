import org.json.*;

    JSONObject obj = new JSONObject(json);
    JSONArray items = (JSONArray) obj.get("items");

    for(int i=0;i<items.length;i++)
    {
      JSONObject item = items.getJSONObject(i);
      JSONObject standardLinks = item.getJSONObject("standardLinks");
      JSONArray self = standardLinks.getJSONArray("self");
      JSONObject selfItem = self.getJSONObject(0);
      System.out.println(selfItem.getString("href"));
      System.out.println(selfItem.getString("title"));  
    }