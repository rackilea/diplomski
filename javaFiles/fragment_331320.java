Scanner fileScanner = new Scanner(file, "UTF-8").useDelimiter(" +| *(?=\\n)|(?<=\\n) *");
while (fileScanner.hasNext()) {
  List<Integer> numbersOnLine = new ArrayList<Integer>();
  while (fileScanner.hasNextInt()) {
    numbersOnLine.add(fileScanner.nextInt());
  }
  processLineOfNumbers(numbersOnLine);
  if (fileScanner.hasNext()) {
    fileScanner.next(); // clear the newline
  }
}