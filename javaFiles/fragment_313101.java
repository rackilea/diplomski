public class Game {

    private Long id;
    private String name;
    private List<Player> players;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> addPlayers(Player player) {
        if (getPlayers() == null)
            setPlayers(new ArrayList<Player>());
        players.add(player);
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}