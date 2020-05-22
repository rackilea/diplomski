final Map<Double,String> map = new TreeMap<>();
map.put(1.2, "String2");
map.put(1.0, "String1");
map.put(-1.0, "String0");
for(Double d : map.keySet()) {
    System.out.println(d + " = " + map.get(d));
}