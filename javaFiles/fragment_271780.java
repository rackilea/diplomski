String nameKey = "Ad hoc";
String theID = "";
Set keys = myjson.keySet();
Iterator iter = keys.iterator();
while(iter.hasNext()) {
    String key = (String)iter.next();
    String name = (String)jsonObject.getJSONObject(key).get("name");
    if (name.equals(nameKey)) {
        theID = key;
    }
}