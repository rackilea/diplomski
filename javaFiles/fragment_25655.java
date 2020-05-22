class MatchResult {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public MatchResult(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
            "homeTeam='" + homeTeam + '\'' +
            ", awayTeam='" + awayTeam + '\'' +
            ", homeScore=" + homeScore +
            ", awayScore=" + awayScore +
            '}';
    }
}