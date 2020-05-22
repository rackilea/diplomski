String[] data = new String[] {"foo 123", "bar 124", "foobar 124","foo 125"};
Map<String,Integer> counts = new LinkedHashMap<String,Integer>();
for (String s : data) {
    String[] tok = s.split(" ");
    Integer count = Integer.valueOf(tok[1]);
    if (!counts.containsKey(tok[0]) || counts.get(tok[0]) < count) {
        counts.put(tok[0], count);
    }
}
for (Map.Entry<String,Integer> e : counts.entrySet()) {
    System.out.println(e.getKey() + " " +e.getValue());
}