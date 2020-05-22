JSONObject jObject = new JSONObject(response);
JSONSONArray p = jObject.getJSONArray("SizeOptions");

for(int i=0;i<p.length();i++)
{
    JSONObject jObjectValue=p.getJSONObject(i);
    String name = jObjectValue.getString("Name");
}