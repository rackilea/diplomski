// s1 contains the set {1, 4, 5, 3}
Set<Integer> s1 = new HashSet<Integer>();
s1.add(1); s1.add(4); s1.add(5); s1.add(3);

// s2 contains the set {1, 2, 3}
Set<Integer> s2 = new HashSet<Integer>();
s2.add(1); s2.add(2); s2.add(3);

// perform the difference between s1 and s2
s1.removeAll(s2);

// now s1 contains the set {4, 5}
System.out.println(s1);
=> [4, 5]