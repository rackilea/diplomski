public static void main(String[] args) {
    String[] array = new String[] {"a", "b", "c"};
    HashSet<String> strings = new HashSet(Arrays.asList(array));

    Map<String, Set<String>> map = new HashMap();
    Map<String, Set<String>> newMap = new HashMap();
    Map<String, Set<String>> cloneMap = new HashMap();

    map.put("key", strings);
    newMap.put("key", new HashSet(strings));
    cloneMap.put("key", (Set<String>) strings.clone());

    strings.add("E");

    System.out.println(map); //{key=[E, b, c, a]}
    System.out.println(newMap); //{key=[b, c, a]}
    System.out.println(cloneMap); //{key=[b, c, a]}

}