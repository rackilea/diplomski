String filename = "ArrayHW2.txt";
char[][] testAnswers = new char[50][5];
try (Scanner input = new Scanner(Paths.get(filename))) {
  for(int row = 0; row < testAnswers.length; row++) {
    for(int col = 0; col < testAnswers[row].length; col++) {
      String token = r.next();
      if (token.length() != 1)
        throw new IllegalArgumentException("Answers must be one character");
      testAnswers[row][col] = token.charAt(0);
    }
  }
} catch (IOException ex) {
  System.err.println("Error reading file: " + ex.getMessage());
  System.exit(1);
}