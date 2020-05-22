private List<Team> teamList;

public League(String name) {        
    // etc...

    for(int i = 0; i < teamNames.size(); i++) {
        teamList.add(new Team(teamNames.get(i))); // This will throw!
    }
}