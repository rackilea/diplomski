public static ArrayList<Integer> noConsecutiveDups(ArrayList<Integer> input) {

  ArrayList<Integer> newList = new ArrayList<Integer>();

  // Always add first value
  newList.add(input.get(0));

  // Iterate the remaining values
  for(int i = 1; i < input.size(); i++) {
    // Compare current value to previous
    if(input.get(i-1) != input.get(i)) {
       newList.add(input.get(i));
    }
  }

  return newList;
}