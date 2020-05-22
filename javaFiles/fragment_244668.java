for (int i = 0; i < userWords.length; i++) {
     int r = rand.nextInt(puzzleBoard.length);
     int c = rand.nextInt(puzzleBoard[r].length - userWords[i].length());
     for (int j = 0; j < userWords[i].length(); j++) {
        puzzleBoard[r][c + j] = userWords[i].charAt(j);
     }
  }