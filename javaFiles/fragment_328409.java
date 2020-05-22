private static Map<String,Boolean> scanForDifferences(Map<String,Object> mapOne, 
                                                      Map<String,Object> mapTwo){

    Map<String,Boolean> retMap = new HashMap<String,Boolean>(); 
    Iterator<Map.Entry<String, Object>> it = mapOne.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String,Object> entry = (Map.Entry<String,Object>)it.next();
        if (mapTwo.get(entry.getKey()).equals(entry.getValue()))
            retMap.put(entry.getKey(), new Boolean(Boolean.TRUE));
        else 
            retMap.put(entry.getKey(), new Boolean(Boolean.FALSE));
        it.remove(); // prevent ConcurrentModificationException
    }
    return retMap;
}