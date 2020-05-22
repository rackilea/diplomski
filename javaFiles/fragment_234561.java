// Your JSON represents an array of objects
JSONArray jsonArray= new JSONArray(yourString);

// Now you have the array, iterate and get the objects
for (int i = 0; i < jsonArray.length(); i++)
{
    JSONObject obj = jsonArray.getJSONObject(i);

    System.out.println("Name" + i + "= " + obj.getString("name"));
    System.out.println("Link" + i + "= " + obj.getString("link"));
}