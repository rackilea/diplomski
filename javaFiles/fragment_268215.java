final Scanner scanner = new Scanner(f);

for (int row = 0; row < mazeHeight && scanner.hasNext(); row++) {
    final String mazeRow = scanner.next(); //Get the next row from the scanner.
    mazePoints[row] = mazeRow.toCharArray(); //Convert the row into a char[].
}