public class MatchFixer {

    private Map<String, List<String>> teamPlayers;

    public MatchFixer() {
        teamPlayers = new HashMap<String, List<String>>();
        teamPlayers.put("Team 1", Arrays.asList(new String[] { "Player 1_1", "Player 1_2" }));
        teamPlayers.put("Team 2", Arrays.asList(new String[] { "Player 2_1", "Player 2_2" }));
        teamPlayers.put("Team 3", Arrays.asList(new String[] { "Player 3_1", "Player 3_2" }));
    }

    public List<Match> generateMatches(){
        List<Match> matches = new ArrayList<Match>();
        for (String homeTeam : teamPlayers.keySet()){
            for (String awayTeam : teamPlayers.keySet()){
                if (!homeTeam.equals(awayTeam)){
                    Match match = new Match(homeTeam, awayTeam);
                    matches.add(match);
                    System.out.println("\tMatch created between "+ homeTeam + " & "+ awayTeam);
                }
            }
        }
        return matches;
    }

    public void initMatch(Match match){
        String homeTeam = match.getHomeTeam();
        String awayTeam = match.getAwayTeam();

        List<String> homePlayers = teamPlayers.get(homeTeam);
        List<String> awayPlayers = teamPlayers.get(awayTeam);

        scoreHomeTeam.getItems().add(homeTeam);
        scoreAwayTeam.getItems().add(awayTeam);

        homeBox.getItems().addAll(homePlayers);
        homeBox2.getItems().addAll(homePlayers);
        awayBox.getItems().addAll(awayPlayers);
        awayBox2.getItems().addAll(awayPlayers);

        System.out.println("\tMatch initialized between "+ homeTeam + " -> "+ homePlayers +" & "+ awayTeam +" -> "+ awayPlayers);
    }

    public static void main(String[] args) {
        MatchFixer fixer = new MatchFixer();

        // Initialize matches with all the combinations of teams
        System.out.println("Initialize the match combinations:");
        List<Match> matches = fixer.generateMatches();

        // Let's initialize the first of our generated matches
        System.out.println("\nInitialize match 1:");
        fixer.initMatch(matches.get(0));
    }
}