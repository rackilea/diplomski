// Create JSONArray
JSONArray jArray = new JSONArray();
while (managedCursor.moveToNext())
{
    final String number = managedCursor.getString(number1);
    final String type2 = managedCursor.getString(type1);
    final String date = managedCursor.getString(managedCursor.getColumnIndexOrThrow("date")).toString();
    Date date1 = new Date(Long.valueOf(date));
    final String fDate = date1.toString();
    final String duration = managedCursor.getString(duration1);
    String type = null;

    // Create JSONObject
    JSONObject item = new JSONObject();

    // add the items to JSONObject
    item.put("number", number);
    item.put("type2", type2);
    item.put("fDate", fDate);
    item.put("duration", duration);

    // add the JSONObject to JSONArray
    jArray.put(item);
}
managedCursor.close();

System.out.println(jArray.toString());