public static void main (String[] args) {
  ArrayList<Integer> list = new ArrayList<Integer>();
  list.add(1);
  list.add(3);
  list.add(4);
  list.add(0);
  printSublists(list, list, 4, true, 0);
}

public static void printSublists(List<Integer> numbers, List<Integer> sublist, int n, boolean walkRight, int level) {

  // the test
  if (sum(sublist) == n)
     System.out.println(sublist);

  // the exit criteia (leaf reached)
  if (sublist.size() == 1)
     return;

  // visit the right sublist
  if (walkRight) 
    printSublists(numbers, sublist.subList(0, sublist.size()-1), n, walkRight, level+1);

  // we only walk the right path once
  walkRight = false;

  // visit the left sublist
  printSublists(numbers, sublist.subList(1, sublist.size()), n, walkRight, level+1);
}