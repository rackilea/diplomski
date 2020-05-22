Integer[] toSort;
try {
    toSort = Pattern.compile("\\s+").splitAsStream(userInput)
        .map(Integer::parseInt).toArray(Integer[]::new);
}catch(NumberFormatException e) {
    System.out.println("Error. Invalid input!\n" + e.getMessage());
    toSort=new Integer[0];
}