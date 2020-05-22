@Entity
public class Player {
...
    private Team team;

    @ManyToOne
    public Team getTeam() { return team; }

    ...
}