static void moves(ArrayList<Integer> prefix, ArrayList<ArrayList<Integer>> result, int min, int max, int stepSize, int maxLength) {
  if(prefix.size() == maxLength) result.add(prefix);
  else {
    for(int i = min; i <= max; i += stepSize) {
      ArrayList<Integer> newPrefix = new ArrayList<Integer>(prefix);
      newPrefix.add(i);
      moves(newPrefix, result, min, max, stepSize, maxLength);
    }
  }
}

static ArrayList<ArrayList<Integer>> moves(int min, int max, int stepSize, int maxLength) {
  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
  moves(new ArrayList<Integer>(), result, min, max, stepSize, maxLength);
  return result;
}