Map<String, Team> teams = new HashMap<String,Team>();

...

if (!teams.containsKey(teamName)) {
    Team t = new Team();
    t.setDescription(teamName);
    teams.put(teamName, t)
}

Player p = new Player();
p.setName(p);
teams.get(teamName).addPlayer(p);

...

saveModels(teams.values());