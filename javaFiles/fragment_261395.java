List<List<Integer>> firsts = new ArrayList<>();
List<List<Integer>> lasts = new ArrayList<>();
List<Integer> prevPair = null;

for(int i = 0; i < list1.length; i++){
  List<Integer> thisPair = Arrays.asList(values1.get(i), values2.get(i));
  List<Integer> prevFirst = firsts.isEmpty() ? null : firsts.get(firsts.size()-1);
  if (getSum(thisPair) != getSum(prevFirst) ) {
    if (prevPair != null) {
      lasts.add(prevPair);
    }
    firsts.add(thisPair);
  }
  prevPair = thisPair;
}
lasts.add(prevPair);

System.out.println(firsts.toString()); // [[3, 3], [6, 5], [9, 6]]
System.out.println(lasts.toString()); // [[5, 1], [8, 3], [11, 4]]