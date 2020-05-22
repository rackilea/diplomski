List<Integer> a = Arrays.asList(1,2,3);
List<Integer> b = Arrays.asList(1,2,3);
Set<List<Integer>> set = new HashSet<>();
set.add(a);
set.add(b);
// set will only contain one list