public void declareWinner(Team team, Game game, Round round) {
    // code that gets current round, game, team numbers to calculate the next round, game, team numbers. 

    int currentRoundNum = rounds.indexOf(round);
    int currentGameNum = round.games.indexOf(game);
    int currentTeamNum = game.teams.indexOf(team);
...