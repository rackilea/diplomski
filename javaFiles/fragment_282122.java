public class UtilClass {

    public static void addMapEntry(Object key, Map<Object, List<Object>> map, Object data){
        List<Object> list = new ArrayList<>();
        if(map.containsKey(key)) {
            list = map.get(key);
        }
        list.add(data);
        map.put(key, list);
    }

    public static  Object[][] getMapAs2dArray(Map<Object, List<Object>> map){
        Object[][] array = new Object[map.keySet().size()][];
        int index = 0;
        for(Object key : map.keySet()){
            array[index] = map.get(key).toArray();
            index++;
        }
        return array;
    }
}