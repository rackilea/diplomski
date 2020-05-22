for (int i = 0; i < golf[0].length; i++) {
    String inn = JOptionPane.showInputDialog("Please enter the golf scores for Player 1", null);
    int n = Integer.parseInt(inn);
    golf[0][i] = n; // use 0 for player 1, 1 for player 2, ...
}
break;