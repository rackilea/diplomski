for (int row = 0; row < arrayHeight; row++) {
    String line = scanner.nextLine();
    System.out.println(line);
    for (int col = 0; col < arrayWidth; col++) {
        mazeArrays[row][col] = line.charAt(col);
    }
}