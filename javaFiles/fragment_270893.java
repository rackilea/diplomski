public class Context {
    private final Map<Class<?>,Map<String,Object>> classMap = new HashMap<>();

    public void put(String name, Object obj) {
        Map<String,Object> map = classMap.get(obj.getClass());
        if (map == null) {
            map = new HashMap<>();
            classMap.put(obj.getClass(), map);
        }
        map.put(name, obj);
    }

    public <T> T get(String name, Class<T> clazz) {
        Map<String,Object> map = classMap.get(clazz);
        if (map == null) {
            return null;
        }
        return clazz.cast(map.get(name));
    }
}