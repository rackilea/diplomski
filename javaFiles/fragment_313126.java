String[] inputData = userInput.split("\\s+");
Integer[] toSort;
try {
    toSort = Arrays.stream(inputData).map(Integer::parseInt).toArray(Integer[]::new);
}catch(NumberFormatException e) {
    System.out.println("Error. Invalid input!\n" + e.getMessage());
    toSort=new Integer[0];
}