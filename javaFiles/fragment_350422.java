public static void main(String[] args) {
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> map1 = new HashMap<>();
    map1.put("header1", "value1");
    map1.put("header2", "value2");
    map1.put("header3", "value3");
    map1.put("header4", "value4");
    Map<String, Object> map2 = new HashMap<>();
    map2.put("header1", "value5");
    map2.put("header2", "value6");
    map2.put("header3", "value7");
    map2.put("header4", "value8");
    list.add(map1);
    list.add(map2);
    System.out.println(toCSV(list));
}