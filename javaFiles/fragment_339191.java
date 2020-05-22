public static <E extends Comparable<? super E>> void removeDuplicates(final ArrayList<E> L) {
final ArrayList<E> temp = new ArrayList<E>(L.size());
final ArrayList<Integer> index = new ArrayList<>(L.size());
int stop = 0;

while (true) {
  //test for duplicates and save their indexes
  for (int i = 0; i < L.size(); i++) {
    if (!temp.contains(L.get(i))) {
      temp.add(L.get(i));
    } else {

      index.add(i);
    }
  }
  // if there were duplicates they will be removed
  if (!index.isEmpty()) {
    stop = 1;
    for (int j = index.size() - 1; j >= 0; j--) {
      L.remove((int) index.get(j));
    }
  }
  //if nothing is removed there should be no duplicates and the loop should break
  if (stop == 0) {
    break;
  }
  index.clear();
  temp.clear();
  stop = 0;
}