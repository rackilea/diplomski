1    for (int i = 0; i < userWords.length; i++) {
2            int r = rand.nextInt(60); 
3            int c = rand.nextInt(puzzleBoard[r].length - userWords[i].length());
4            for (int j = 0; j < userWords[i].length(); j++) {
5                puzzleBoard[r+j][c+j] = userWords[i].charAt(j); // -j-j = dia right backward || +j+j= dia right forward || -j+j dia forward || +j-j dia backward
6            }
7        }
8    }