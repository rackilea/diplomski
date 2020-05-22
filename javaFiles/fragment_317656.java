import org.json.*;

...

JSONArray arr = obj.getJSONArray("statuses");

for (int i = 0; i < arr.length(); i++)
{
    String id = arr.getJSONObject(i).getString("id_str");
    ......
}