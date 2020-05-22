Map<String, Integer> map = new LinkedHashMap<>();
for (String w : data) {
    Integer n = map.get(w.toLowerCase());
    n = (n == null) ? 1 : ++n;
    map.put(w.toLowerCase(), n);
}
System.out.println(map);