SortedMap<Integer, Character> tail = l.tailMap(yourKey);
int cnt = 0;
List<Char> result = new ArrayList<Character>();
for (Iterator<Entry<Integer, Character>> it = tail.iterator(); it.hasNext() && cnt < 3; cnt++) {
  reasult.add(it.next());
}