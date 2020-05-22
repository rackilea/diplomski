public class Team {
    private List<Player> players;
    private String name;

    public Team (String name, List<Player> players) {
        this.players = players;
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }
}