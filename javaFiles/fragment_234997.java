String [] team = {"Astonvilla", "Realmadrid", "Ajax", "Barcelona", "Manunited"};
for(int i = 0; i < 3; i++) {
    String [] result={"0","1","2"}; 

    int chooseTeam = (int)(Math.random()*(team.length-i));
    int chooseResult = (int)(Math.random()*result.length);

    System.out.println("Team is " + team[chooseTeam] + " Result is " 
        + result[chooseResult]);
    String teamName = team[team.length-1];
    team[team.length-1] = team[chooseTeam];
    team[chooseTeam] = teamName;
}