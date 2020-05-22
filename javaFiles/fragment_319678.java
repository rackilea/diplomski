JSONObject pages = obj.get("pages");
Iterator iterator = pages.keys();
while(iterator.hasNext()){
    String key = (String)iterator.next();
    JSONObject page = pages.getJSONObject(key);

    //do stuff with the page...
}