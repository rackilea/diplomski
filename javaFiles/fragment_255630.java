//Assuming this is called when the Start button is clicked
public void fullGame() {
    takePCTurn();
}

public void takePCTurn() {
    //Do PC's turn logic
    //You might want to check if the Computer Won the game here        
}


class PlayerTurnListener implements ActionListener() {
    public void actionPerformed(ActionEvent e) {
        //Do Player's turn logic            
        //You might want to check if the Player Won the game here
        takePCTurn();
    }
}

//We can create an instance of our listener and add it to both buttons
PlayerTurnListener playerTurnListener = new PlayerTurnListener();

leftButton.addActionListener(playerTurnListener);
rightButton.addActionListener(playerTurnListener);