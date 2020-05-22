for (Player p : inGamePlayers) {

    if (newUsername == p.username) { // This needs to be .equals
      System.out.println(p.username+" reconnected!");
      break;
    }
    // this line runs many times
    inGamePlayers.add(new Player(newUsername));
  }