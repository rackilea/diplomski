List<Integer> numbers = new ArrayList<Integer>(100);

for (int i = 0; i < 100; ++i)
  numbers.add(i);

Collections.shuffle(numbers);

int pick = numbers.remove(0);
int pick2 = numbers.remove(0);