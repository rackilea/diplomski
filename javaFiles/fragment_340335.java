public class FlatMap {

    public static Stream<Object> flatten(Object o) {
        if (o instanceof Map<?, ?>) {
            return ((Map<?, ?>) o).values().stream().flatMap(FlatMap::flatten);
        }
        return Stream.of(o);
    }

    public static void main(String[] args) {
        Map<String, Object> map0 = new TreeMap<>();
        map0.put("key1", "value1");
        map0.put("key2", "value2");
        Map<String, Object> map1 = new TreeMap<>();
        map0.put("key3", map1);
        map1.put("key3.1", "value3.1");
        map1.put("key3.2", "value3.2");
        Map<String, Object> map2 = new TreeMap<>();
        map1.put("key3.3", map2);
        map2.put("key3.3.1", "value3.3.1");
        map2.put("key3.3.2", "value3.3.2");

        List<Object> collect = map0.values().stream()
                                            .flatMap(FlatMap::flatten)
                                            .collect(Collectors.toList());
        // or
        List<Object> collect2 = flatten(map0).collect(Collectors.toList());
        System.out.println(collect); 
    }
}