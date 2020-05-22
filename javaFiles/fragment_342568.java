List<Integer> A = readFromFile("a.csv"); // Arrays.asList(1,2,4)
List<Integer> B = readFromFile("b.csv"); // Arrays.asList(1,2,3)

Set<Integer> set = new TreeSet<Integer>() // will sort for you as well
set.addAll(A)
set.addAll(B)