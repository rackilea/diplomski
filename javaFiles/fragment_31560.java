import org.json.JSONArray;
import org.json.JSONObject;

... skip ...

//JSONObject ob = JSONObject.fromObject(resBuf.toString());
JSONObject ob = new JSONObject(resBuf.toString());
if(ob.has("d"))
{
    JSONObject dobj = ob.getJSONObject("d");

    if(dobj.has("results"))
    {
        JSONArray arr = dobj.getJSONArray("results");

        System.out.println(arr.length());

        for (int i = 0; i < arr.length(); i++) {
            JSONObject jsonAuth = arr.getJSONObject(i);
            String PREFIX = jsonAuth.get("PREFIX").toString();
            System.out.println(PREFIX);
        }
    }

}