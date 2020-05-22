int winScore = 75;
Player p1 = new Player("Player 1", winScore );
Player p2 = new Player("Player 2", winScore );
Player current = null;

//might be dangerous if due to a bug no player would ever win but we'll leave it simple for now
//we just loop forever and break the loop from the inside whenever a player won
while ( true ) {
  //p1 has had his turn so now it's p2's turn
  if( current == p1 ) {
    current = p2;
  } else {
    current = p1;
  }

  boolean won = current.executeTurn();

  //the player won so end the loop
  if( won ) {
    break;
  }
}

//since we didn't change the current player after he's won we just can get his name
System.out.println(current.getName() + " won");