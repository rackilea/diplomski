public class ObjMapStore {
    public ObjMapStore(){
        this(true);
    }
    public ObjMapStore(boolean loadDefault){
        map = new HashMap<>();
        if(loadDefault){
            map.put("defParam1", 123); // (int) DefaultRegistrator.getDefault("ObjMapStore", "defParam1");
            map.put("defParam2", 123); // (int) DefaultRegistrator.getDefault("ObjMapStore", "defParam2");
            map.put("defParam3", 123); // (int) DefaultRegistrator.getDefault("ObjMapStore", "defParam3");
        }
    }

    public void put(String key, Object value){
        map.put(key, value);
    }

    public Map<String, Object> getMap(){
        return map;
    }
    private Map<String, Object> map;
}