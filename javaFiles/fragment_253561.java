List<String> numbersInAList = Arrays.asList("1", "2", "-3");
int[] numbers = new int[numbersInAList.size()];

for (int ndx = 0; ndx < numbersInAList.size(); ndx++) {
   try {
      numbers[ndx] = Integer.parseInt(numbersInAList.get(ndx));
   } catch (NumberFormatException formatException) {
      System.out.println("Oops, that's not a number");
   }
}