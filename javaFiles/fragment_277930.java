List<Team> result = new ArrayList<Team>();
for (Team team : this.teams) {
    if (team.isActive()) { 
        result.add(team);
    }
}
return result;