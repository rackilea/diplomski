@Benchmark public ArrayList<Integer> binarySearchAL() {
  ArrayList<Integer> list = new ArrayList<> ();

  Random r = new Random();
  for (int i = 0; i < n; i++) {
    int num = r.nextInt();
    int index = Collections.binarySearch(list, num);
    if (index >= 0) list.add(index, num);
    else list.add(-index - 1, num);
    current = list.get(0); //O(1), to make sure the sort is not optimised away
  }
  return list;
}