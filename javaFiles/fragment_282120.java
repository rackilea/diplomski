public class UtilClass {

    private Map<Object, List<Object>> map = new HashMap<>();

    public void addMapEntry(Object key, Object data){
        List<Object> list = new ArrayList<>();
        if(map.containsKey(key)) {
            list = map.get(key);
        }
        list.add(data);
        map.put(key, list);
    }

    public Object[][] getMapAs2dArray(){
        Object[][] array = new Object[map.keySet().size()][];
        int index = 0;
        for(Object key : map.keySet()){
            array[index] = map.get(key).toArray();
            index++;
        }
        return array;
    }

    public Map<Object, List<Object>> getMap() {
        return map;
    }
}