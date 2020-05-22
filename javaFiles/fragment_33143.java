// if connected, read file
if (inputFile != null) {
  System.out.print("number of integers in file \""
      + filename + "\" = \n");
  // loop through file for integers and store in array
  try {
    while (inputFile.hasNext()) {
      if (inputFile.hasNextInt()) {
        array[i] = inputFile.nextInt();
        i++;
      } else {
        inputFile.next();
      }
    }
  } finally {
    inputFile.close();
  }
  // I think you wanted to print it.
  System.out.println(i);
  for (int v = 0; v < i; v++) {
    System.out.printf("array[%d] = %d\n", v, array[v]);
  }
}