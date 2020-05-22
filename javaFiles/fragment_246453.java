Map<String,String> myMap;

public List<String> getMapKeys(){
    List<String> ret = new ArrayList<String>();
    for (String s : myMap.keySet())
        ret.add(s);
    return ret;
}