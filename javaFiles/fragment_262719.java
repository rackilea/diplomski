public static void main(String[] args) {
  Player adam = new Player("Adam");
  Player pat = new Player("Pat");
  Player susie = new Player("Susie");
  List<List<Score>> scores = new ArrayList<> ();
  scores.add(Arrays.asList(s(adam, 1), s(pat, 2), s(susie, 3)));
  scores.add(Arrays.asList(s(adam, 2), s(pat, 4), s(susie, 6)));
  scores.add(Arrays.asList(s(adam, 3), s(pat, 6), s(susie, 9)));

  Map<Player, Double> scoreByPlayer = scores.stream()
                  .flatMap(List::stream)
                  .collect(groupingBy(Score::getPlayer, averagingInt(Score::getScore)));

  scoreByPlayer.forEach((p, s) -> System.out.println(p + " : " + s));
}

private static Score s(Player p, int score) { return new Score(p, score); }

public static class Score {
  private final Player player;
  private final int score;
  public Score(Player player, int score) {
    this.player = player;
    this.score = score;
  }

  public Player getPlayer() { return player; }
  public int getScore() { return score; }
}

public static class Player {
  private final String name;
  public Player(String name) { this.name = name; }
  @Override public String toString() { return name; }
}