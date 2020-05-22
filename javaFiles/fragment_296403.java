Vector<Integer> c = new Vector<Integer>();
// add elements to c

Set<Integer> unique = new HashSet<Integer>();
unique.addAll(c);
for (Integer i : unique) {
    System.out.println(i);
}