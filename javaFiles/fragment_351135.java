String player1Choice = liste.getSelectedValue()
String player2Choice = liste2.getSelectedValue()

if (player1Choice.equals(player2Choice)
    System.out.println("Draw"); // Or whatever you want to output to, could be another jLabel
else if(player1Choice.equals(rock) && player2Choice.equals(paper))
    System.out.println("Player 2 wins.");

// And just keep adding on here.....