List<Location> locations = new ArrayList<Location>();

for (JSONObject c : locations_resp)
{
    int id = c.getInt("id");
    String name = c.getString("title");
    if(name != null && name.length > 0)
    {
        locations.add(new Location(name, id));
    }
}