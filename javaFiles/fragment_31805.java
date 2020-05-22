ListIterator<Time[]> it = workingList.listIterator();

while (it.hasNext()) {
  Time[] time = it.next();
  ..
  it.remove();
}