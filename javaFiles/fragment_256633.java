private static void handleConnected(ArrayList<Player> inGamePlayers, String newUsername) {
  for (Player p : inGamePlayers) {
    if (newUsername.equals(p.username)) {
      System.out.println(p.username+" reconnected!");
      return; // return instead of break
    }
  }
  // we did not return, so this user is new
  inGamePlayers.add(new Player(newUsername));
}

// ...

public static void main(String[] args) {
  ArrayList<Player> inGamePlayers = new ArrayList<Player>();
  inGamePlayers.add(new Player("Griff"));

  String newUsername = "Polak";

  // Call this function in place of the old loop
  handleConnected(inGamePlayers, newUsername);

  for (Player p : inGamePlayers) {
    System.out.println(p.username);
  }
}