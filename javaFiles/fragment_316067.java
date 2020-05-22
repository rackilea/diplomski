// could also be static
private Map<String, Callable<Map>> myLoaders;

private synchronized void loadMap(Object map, String mapName)
{
if (map == null)
    try
    {
       Callable<Map> mapLoader = myLoaders.get(mapName);
       map = mapLoader.call();
    } 
    catch (..)
}

// and in the constructor or other init code
myLoaders.put("map1", new Callable<Map>(){
     Map call(){
        // load map 1
     }});