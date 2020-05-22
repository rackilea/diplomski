static class MyTreeMap<K, V> extends TreeMap<K, V> {
}

public static void main(String[] main) {
    HashMap<String, Integer> map1 = new HashMap<>();
    map1.put("one", 1);
    map1.put("two", 2);
    map1.put("three", 3);
    HashMap[] res = split(map1, 2, HashMap::new);
    Arrays.stream(res).forEach(System.out::println);

    MyTreeMap<Double, Boolean> map2 = new MyTreeMap<>();
    map2.put(.5, true);
    map2.put(5d, false);
    MyTreeMap[] res2 = split(map2, 1, MyTreeMap::new);
    Arrays.stream(res2).forEach(System.out::println);
}