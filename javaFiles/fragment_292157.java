String test = new String(board[row], col, word.length());
if (test.equals(word)) {

    System.out.println("Found [" + word + "] @ " + row + "x" + col);

}