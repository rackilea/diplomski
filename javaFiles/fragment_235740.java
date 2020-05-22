public void declareWinner(Team team, Game game, Round round) {
    // code that gets current round, game, team numbers to calculate the next round, game, team numbers. 

    int currentRoundNum = rounds.indexOf(round);
    int currentGameNum = rounds.get(currentRoundNum).games.indexOf(game);
    int currentTeamNum = rounds.get(currentRoundNum).games.get(currentGameNum).teams.indexOf(team);
    ...