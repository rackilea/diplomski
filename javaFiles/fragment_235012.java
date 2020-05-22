List<Integer> numberList = new ArrayList<Integer>();
  int[] myInts = {1, 1, 2, 3, 3, 3, 3, 4};
  for (int i : myInts) {
     if (!numberList.contains(i)) {
        numberList.add(i);
      }
  }

  System.out.println(numberList);