TreeMap<Integer, Object> m = new TreeMap<>(new Comparator<Integer>() {
    public int compare(Integer o1, Integer o2) {
        return o1.equals(o2) ? 1 : o1.compareTo(o2);
    }
});
m.put(0, 0);
m.put(1, 1);
m.put(1, 1);
m.put(1, 1);
m.put(2, 2);
m.put(3, 3);
m.put(4, 4);
System.out.println(m.subMap(0, false, 3, true));