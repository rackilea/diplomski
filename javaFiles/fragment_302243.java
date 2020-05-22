if(m.containsKey(team1))
    return m[team1].equals(team2);
if(m.containsKey(team2))
    return m[team2].equals(team1);

return false;