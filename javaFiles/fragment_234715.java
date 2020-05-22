List<B> listB = new ArrayList(listA.size());
for (A a : listA) {
  if (a == null || a instanceof B) {
    listB.add((B) a);
  } else {
    //Either ignore or throw exception
  }
}