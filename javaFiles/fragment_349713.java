Map<Double,String> m = new HashMap<Double,String>();

String pre = "abc";
String post = ".txt";
for (int ii = 0; ii < 10; ii++) {
    m.put(Math.random(),pre + ii + post);
}
SortedSet<Double> set = new TreeSet<Double>(m.keySet());
for (Double d : set) {
    System.out.println(d + " " + m.get(d));
}