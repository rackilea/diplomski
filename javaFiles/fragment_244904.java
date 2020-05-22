public class Game {
    List<Player> players = new List<Player>();
    public Game() {
    }
    public void AddPlayer(Player p) {
        players.add(p);
    }
    public Player getPlayer(int index) { return players.get(index); }
    public void playerBowl(Player p) {
        ran1 = (int) (9 * Math.random());
        ran2 = (int) (((10 - ran1)) * Math.random());

        if (ran1 == 10){
            p.setScore(p.getScore() +20);
        } else if (ran1 + ran2 == 10){
            p.setScore(p.getScore() +15);
        } else {
            p.setScore(p.getScore() + ran1 + ran2);
        }   System.out.println("Player " + p.getName() + " score is: " + p.getScore() + "\n");
        System.out.println("ran1: " + ran1 + "  ran2: " + ran2);
    }
}