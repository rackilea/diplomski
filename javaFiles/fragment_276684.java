JSONArray arr = value.getJSONArray("oteviracidoba");
Object[] shops = new Object[arr.length];
for (int i = 0; i < arr.length(); i++) {
    shops[i] = arr.getJSONObject(i);
}
//if item has array of objects in its constructor then pass it there.
mList.add(new Item(monumentnumber, monumentname, monumentregion, monumentregion2, monumenttown, description, web, shops));