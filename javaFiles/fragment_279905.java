List<String> locations = new ArrayList<String>();
List<String> locationsId = new ArrayList<String>();

for (JSONObject c : locations_resp)
{
    int id = c.getInt("id");
    String name = c.getString("title");
    if(name != null && name.length > 0)
    {
        locations.add(name);
        locationsId.add(String.valueOf(id));
    }
}