public static void main(String args[]) {
HashMap<String, Object> map = new HashMap<String, Object>();
map.put("2", "whatever2");
map.put("1", "whatever1");
TreeMap<String, Object> map2 = new TreeMap<String, Object>();
map2.put("2", "whatever2");
map2.put("1", "whatever1");

System.out.println("Are maps equal (using equals):" + map.equals(map2));
System.out.println("Are maps equal (using toString().equals()):"
        + map.toString().equals(map2.toString()));

System.out.println("Map1:"+map.toString());
System.out.println("Map2:"+map2.toString());
}