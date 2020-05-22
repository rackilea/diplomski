Multiset<Integer> seen = HashMultiset.create();
for (int[] row : arr) {
  for (int elem : row) {
    seen.add(elem); // none of that nasty dealing with the Map
  }
}
// you can look up the count of an element with seen.count(elem)
E mostCommon = null;
int highestCount = 0;
for (Multiset.Entry<Integer> entry : seen.entrySet()) {
  if (entry.getCount() > highestCount) {
    mostCommon = entry.getElement();
    highestCount = entry.getCount();
  }
}
return mostCommon; // this is the most common element