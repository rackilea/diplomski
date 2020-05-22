for(int x = 0; x < 64; x++) {
    if(e.getSource() == board[x] &&
       board[x].getText().equals("0") &&
       board[x].getForeground().equals(Color.WHITE)) {
       board[x].setBackground(Color.YELLOW);
       int myPos = x % 8;
       if(myPos < 7) {
          // Up and to the right, only if we are not rightmost.
          board[x-7].setBackground(Color.GREEN);
       }
       if(myPos > 0) {
          // Up and to the left, only if we are not leftmost.
          board[x-9].setBackground(Color.GREEN);
       }
    }       
}