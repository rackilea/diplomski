@Transient
    public Set<Game> getGames() {
        Set<Game> allGames = new HashSet<Game>(team1Games);
        allGames.addAll(team2Games);
        // Or use google-collections Sets.union() for bonus points
        return allGames;
    }