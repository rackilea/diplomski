for (Team team : mTeams) {
    for (Team team1 : mTeams) {
        if (team.equals(team1)) continue;
        match(team, team1);
    }
}