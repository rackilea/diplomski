List<Object> list = new ArrayList<Object>();
list.add(1);
list.add(2);
list.add(3);
for (Object o : list) {
    // Now an explicit cast is required
    Integer n = (Integer)o;
    System.out.println(n+5);
}