List<Object> l = new LinkedList<Object>();
List<Integer> r = new LinkedList<Integer>();
l.add(new Integer(1));
l.add(new Integer(2));
l.add(new Integer(3));
l.add("a");
l.add("b");

System.out.println(l);

for(Object o: l) {
    if (o instanceof Integer) {
        r.add((Integer) o);
    }
}

System.out.println(r);