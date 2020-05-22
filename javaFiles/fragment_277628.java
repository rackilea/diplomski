JSONArray array = jobj.getJSONArray("root");
JSONObject subObj;
JSONArray subArray;

for (int i = 0; i < array.length(); i++)
{
    subObj = array.getJSONObject(i);

    if (subObj.has("Sc_wesam")) // handle Se_wesam
    {
        subArray = subObj.getJSONArray("Sc_wesam");

        for (int j = 0; j < subArray.length(); j++)
        {
            subObj = subArray.getJSONObject(j);
            if (subObj.has("head"))
                System.out.println("Sc_wesam head value: " +
                                   subObj.getString("head"));
            else if (subObj.has("color"))
                System.out.println("Sc_wesam color value: " +
                                   subObj.getString("color"));
        }
    }
    else if (subObj.has("Sc_we")) // handle Se_we
    {
        subArray = subObj.getJSONArray("Sc_wesam");

        // ... etc.
    }
}