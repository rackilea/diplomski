for (int i = 0; i < columns; i++) {
    System.out.print("Please enter the number of rows: ");
    int numrows = stdin.nextDouble();
    twoDArray[i] = new double[numrows];  // need to initialize the array first

    System.out.println("Please enter the array elements by rows: ");
    for (int j = 0; j < twoDArray[i].length; j++) {
        twoDArray[i][j] = stdin.nextDouble();
    }
}