public class Team {
        ...
        @OneToMany(mappedBy="team1")
        private Set<Game> team1Games;
        @OneToMany(mappedBy="team2")
        private Set<Game> team2Games;