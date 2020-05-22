@Entity
public class Team {
    ...    
    private Set<Player> players = new HashSet<Player();

    public Team() { }

    @OneToMany(mappedBy = "team")
    public Set<Player> getPlayers() { return players; }

    ...    
}