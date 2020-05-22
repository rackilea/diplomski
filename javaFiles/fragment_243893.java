Scanner fileScanner = new Scanner(myFile);
while (fileScanner.hasNextLine()) {
  Scanner lineScanner = new Scanner(fileScanner.nextLine());

  // use the lineScanner to extract tokens from the line

  lineScanner.close();
}
fileScanner.close(); // likely done in a finally block after null check