while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    System.out.println(line);
    for (int row = 0; row < arrayHeight; row++) {
        for (int col = 0; col < line.length(); col++) {
            mazeArrays[row][col] = line.charAt(col);
        }
    }
}