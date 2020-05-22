public static void main(String[] args) {

    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    map.put("Hello", Arrays.asList(1, 2));
    map.put("World!", Arrays.asList(3));

    Multimap<String, Integer> multimap = toMultiMap(map);

    Iterator<Entry<String, Integer>> it = multimap.entries().iterator();

    while (it.hasNext())
        System.out.println(it.next());
}