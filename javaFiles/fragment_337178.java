Iterator<Integer> it = list.iterator();
int i = 0;
while (it.hasNext() && it.next() == 0) {
  ++i;
}
list.subList(0, i).clear();