List<Integer> subList = new ArrayList<>();

for (Integer i : ints) { //better not to unbox
  if (someCondition(i)) subList.add(i);
}

for (int i : ints) { //better to unbox once
  int a = i;
  int b = 2 * i;
  sum += a + b - i;
}