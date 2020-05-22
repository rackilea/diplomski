List<Integer> a = new ArrayList<>();
List<Integer> b = new ArrayList<>();
a.add(new Integer(0));
b.add(new Integer(0));

System.out.println(a.hashCode());
// 31

System.out.println(b.hashCode());
// 31

System.out.println(a.equals(b));
// true