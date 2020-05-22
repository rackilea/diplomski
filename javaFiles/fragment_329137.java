Set<Integer> set1 = new HashSet<>();
set1.add(10);
set1.add(11);
Set<Integer> set2 = new HashSet<>(set1);

System.out.println("Initial set 1:\n" + set1);
System.out.println("set2 constructed with set1:\n" + set2);
set1.add(12);
System.out.println("Adjusted set1 with 12:\n" + set1);
System.out.println("set2 after set1 adjustment:\n" + set2);