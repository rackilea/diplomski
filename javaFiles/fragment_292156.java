if (col - word.length() >= 0) {
    for (int letters = 0; letters < word.length(); letters++) {
        if (word.charAt(letters) == board[row][col-letters]) {
            System.out.println(word.charAt(letters) + " Found at: " + Arrays.toString(new int[] {row,col+letters}));
        } 
    } // end search to the right
}