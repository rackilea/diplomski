Map<String, Integer> map = new HashMap<String, Integer>();
List<T> list = new ArrayList<T>();
for(T t : list) {
    if(map.containsKey(t.attr1)) {
        map.put(t.attr1, map.get(t.attr1) + t.attr2);
    }else {
        map.put(t.attr1, t.attr2);
    }
}
System.out.println(map);