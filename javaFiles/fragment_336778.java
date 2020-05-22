private ArrayList<Player> arrayOfPlayers = new ArrayList<>();
private int intOfPlayers;

public void noOfPlayers() {

    while (true) {
        String inputValue = JOptionPane.showInputDialog("Please input the number of players");

        if (inputValue != null) { // Text was entered, cancel not clicked
            try {
                intOfPlayers = Integer.parseInt(inputValue);
                if (intOfPlayers > 4 || intOfPlayers < 1) {
                    JOptionPane.showMessageDialog(null, "Only 1-4 can play!", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    break; // stop asking for numbers
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number!", "Error!", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace(); // never ignore errors, even if obvious
            }
        } else {
            System.out.println("Quitting from number players input");
            System.exit(0); // Canceled the dialog, so quit the program
        }

    }

    for (int z = 0; z < intOfPlayers; z++) {
        String playerName = JOptionPane.showInputDialog("Player " + (z + 1) + " please input your name");
        if (playerName != null) {
            // chooseCounter(playerName);
            arrayOfPlayers.add(new Player(playerName, (z + 1), null, 0));
        } else {
            System.out.println("Quitting from player " + (z + 1) + " name input");
            System.exit(0); // Canceled the dialog, so quit the program
        }
    }

    printPlayerNames();
}

private void printPlayerNames() {
    for (int z = 0; z < arrayOfPlayers.size(); z++) {
        String currentPlayer = arrayOfPlayers.get(z).playerNme;
        System.out.println(currentPlayer);
    }
}