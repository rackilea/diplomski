synchronized (list) {
  int i = 0;
  while (i < list.size())
  {
    if (testSomeCondition(list.get())) {
      list.remove(i);
    else
      i++;
  }
}