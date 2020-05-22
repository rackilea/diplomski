JSONobject data = new JSONObject(jsonStringData);
JSONArray cholesterol = data.getJSONArray("cholesterol");
for(int i = 0; i < cholesterol.length; i++)
{
    JSONObject object = cholesterol.getJSONObject(i);
    // Create a new object of your POJO class
    CholesterolInformation ci = new CholesterolInformation();
    // Get value from JSON
    String date = object.getString("date");
    // Set value to your object using your setter method
    ci.setDate(date);
    String hdl = object.getString("hdl");
    ci.setHdl(hdl);
    .....
    .....
    // Finally, add the object to your arraylist
    mCholesterol.add(ci);
}