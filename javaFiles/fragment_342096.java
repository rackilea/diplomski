List<HashMap<String, String>> artEvents = ...;

//this map stores all of the result maps (one map per uri_path, uri_path is the key in this uniqueUriMap, map itself being a value).
HashMap<String, HashMap<String, String>> uniqueUriMap = new HashMap<String, HashMap<String, String>>(); 

for (HashMap<String, String> mapBeingProcessed : artEvents) 
{
    String uri_path = mapBeingProcessed.get("uri_path");
    Double art = Double.parseDouble(mapBeingProcessed.get("avgRespT"));   
    Integer count =Integer.parseInt(mapBeingProcessed.get("count"));

    if (uniqueUriMap.containsKey(uri_path)) 
    {
        Double artFromMap = Double.parseDouble(uniqueUriMap.get(uri_path).get("avgRespT"));
        int countFromMap = Integer.parseInt(uniqueUriMap.get(uri_path).get("count"));
        count = count + countFromMap;
        art = ((art * count) + (artFromMap * countFromMap)) / count;
    }

    HashMap<String, String> newUriMap = new HashMap<String, String>();
    newUriMap.put("uri_path",uri_path);
    newUriMap.put("avgRespT",String.valueOf(art));
    newUriMap.put("count", String.valueOf(count));
    uniqueUriMap.put(uri_path, newUriMap);
}
//result list.
List<HashMap<String, String>> artProcessedEvents=new ArrayList<HashMap<String, String>>();
artProcessedEvents.addAll(uniqueUriMap.values());