public static void display(String[] itemNames5, 
    Integer[] itemNumbers5, Integer listSize, String [] StoreNames5) {
    // divides each line by commas
    Scanner lineInput = new Scanner(firstLineOfFile).useDelimiter(",");
    //get the two headers from the first line of the file   
    String header1 = lineInput.next();
    String header2 = lineInput.next();
    String header3 = lineInput.next();

    // display headings
    System.out.println("Row        " + header1 + "    " + header2 + "    " +      header3);
    // loop through the array
    for (int i = 0; i < listSize; i++) {
      // display grocery list items as a numbered list
      System.out.printf("%2d     %8s     %3d    %8s\n", i+1, itemNames5[i],  itemNumbers5[i], StoreNames5[i]);
  }