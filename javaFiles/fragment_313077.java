public static Integer[] readFileReturnIntegers(
    String filename) {
  Integer[] temp = new Integer[1000];
  int i = 0;
  // connect to the file
  File file = new File(filename);
  Scanner inputFile = null;
  try {
    inputFile = new Scanner(file);
  }
  // If file not found-error message
  catch (FileNotFoundException Exception) {
    System.out.println("File not found!");
  }
  // if connected, read file
  if (inputFile != null) {
    // loop through file for integers and store in array
    try {
      while (inputFile.hasNext()) {
        try {
          temp[i] = inputFile.nextInt();
          i++;
        } catch (InputMismatchException e) {
          inputFile.next();
        }
      }
    } finally {
      inputFile.close();
    }
    Integer[] array = new Integer[i];
    System.arraycopy(temp, 0, array, 0, i);
    return array;
  }
  return new Integer[] {};
}

public static void printArrayAndIntegerCount(
    Integer[] array, String filename) {
  System.out.printf(
      "number of integers in file \"%s\" = %d\n",
      filename, array.length);
  for (int i = 0; i < array.length; i++) {
    System.out.printf(
        "\tindex = %d, element = %d\n", i, array[i]);
  }
}