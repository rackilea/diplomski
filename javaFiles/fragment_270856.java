if(board[0][0] != null && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
     JOptionPane.showMessageDialog(null,string + " won."); 
} else if(board[0][2] != null && board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
     JOptionPane.showMessageDialog(null,string + " won."); 
} else if(count == 9) {
     JOptionPane.showMessageDialog(null, "draw."); 
} else {
    for (int i = 0; i < 3; i++) {
        if (board[i][0] != null && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
            JOptionPane.showMessageDialog(null, string + " won."); break;
        } 
        if (board[0][i] != null && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
            JOptionPane.showMessageDialog(null, string + " won."); break;
        }
    }
}