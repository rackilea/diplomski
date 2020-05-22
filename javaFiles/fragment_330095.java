final int currentNumOfPlayers = numOfPlayers;
EventQueue.invokeLater(new Runnable() {
    public void run() {
       numPlayers.setText("There are currently " + 
               currentNumOfPlayers + " players in this game");
    }
});