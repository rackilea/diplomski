@Entity
public class Team {

    @OneToMany(mappedBy="homeTeam")
    private Set<Match> homeMatches = new HashSet<>(); 

    @OneToMany(mappedBy="awayTeam")
    private Set<Match> awayMatches = new HashSet<>(); 

    // getters and setters


    // special getter if you want it
    public Set<Match> getAllMatches() {
        Set<Match> allMatches = new HashSet<>(); 
        allMatches.addAll(homeMatches);
        allMatches.addAll(awayMatches);
        return allMatches;
    }

}

@Entity
public class Match {

    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_ID", referencedColumnName = "TEAM_ID")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "AWAY_TEAM_ID", referencedColumnName = "TEAM_ID")
    private Team awayTeam;
}