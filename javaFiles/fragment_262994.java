ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>(indexMap.values());
ArrayList<Integer> allInts = new ArrayList<Integer>();
for(ArrayList<Integer> ints : arrays) {
   allInts.addAll(ints);
}
Integer[] valuesProblem2 = (Integer[])allInts.toArray(new Integer[0]);