if (col + word.length() <= board[row].length) {

    int letters = 0;
    while (letters < word.length() && word.charAt(letters) == board[row][col + letters]) {
        letters++;
    }

    if (letters == word.length()) {
        System.out.println("Found [" + word + "] @ " + row + "x" + col);
    }
}