public static void main(String[] args) {
    List<Map<String, Object>> list1 = new ArrayList<>();
    list1.add(map("Month", "August-13", "Sales", 282200));
    list1.add(map("Month", "July-13", "Sales", 310400));
    System.out.println("list1 = " + list1);

    List<Map<String, Object>> list2 = new ArrayList<>();
    list2.add(map("Month", "August-13", "NoOfTranx", 6700));
    list2.add(map("Month", "July-13", "NoOfTranx", 14400));
    System.out.println("list2 = " + list2);

    Map<String, Map<String, Object>> result = Stream.concat(list1.stream(),
                                                            list2.stream())
                .collect(toMap(m -> (String) m.get("Month"),
                               m -> m,
                               (m1, m2) -> {m1.putAll(m2); return m1; }));

    List<Map<String, Object>> merge = new ArrayList<>(result.values());
    System.out.println("merge = " + merge);
}

private static Map<String, Object> map(Object... kvs) {
    Map<String, Object> map = new HashMap<>();
    for (int i = 0; i < kvs.length; i += 2) {
        map.put((String) kvs[i], kvs[i+1]);
    }
    return map;
}