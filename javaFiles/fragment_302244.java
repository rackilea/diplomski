if(m.containsKey(team1))
    return m[team1].contains(team2);
if(m.containsKey(team2))
    return m[team2].contains(team1);

return false;