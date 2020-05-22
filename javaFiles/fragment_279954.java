class PaintballPlayer {

  private static int totalPlayers;

  public PaintballPlayer() {
    totalPlayers++;
  }

  public static int getTotalPlayers() {
    return totalPlayers;
  }
}