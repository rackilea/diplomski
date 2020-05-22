boolean checkList(List<Integer> list) {
  if (list.isEmpty())
    return false;

  int value = list.get(0);
  for (int i = 1; i < list.size(); ++i) {
    if (list.get(i) != value)
      return false;
  }

  return true;
}