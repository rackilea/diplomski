public AssaultTeam getTeam(String teamName) {
        //iterate throught the teams list - OK
        for(AssaultTeam team : teams){
            if(team.getName().equals(teamName)){
                //if found - OK
                return team;
            }
        }
        AssaultTeam newTeam = new AssaultTeam(teamName);
        teams.add(newTeam);
        //call the getTeam, which will cause another iteration to find the item - NOT GOOD
        //return getTeam(teamName);
        //just return item you just created
        return newTeam;
    }