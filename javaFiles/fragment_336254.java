System.out.println("Enter the number to remove");
  int removeElement = in.nextInt();

  List<Integer> list = new ArrayList<Integer>(array.length);

  for (int number : array) {
      if (number != removeElement) {
          list.add(number);
      }
  }

  array = new int[list.size()];

  for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
  }