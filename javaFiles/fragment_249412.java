List<Integer> values = new ArrayList<>();

while (number != stopInput) {
  System.out.print("Enter a number: ");
  values.add(Integer.valueOf(input.nextInt()));
}

Integer[] array = values.toArray(new Integer[values.size()]);