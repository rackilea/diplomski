HashSet<Integer> alreadyUsed = new HashSet<Integer>();
for(int i = 0; i < 3; i++) {
    String [] team = {"Astonvilla", "Realmadrid", "Ajax", "Barcelona", "Manunited"};
    String [] result={"0","1","2"}; 

    int chooseTeam;
    do {
        chooseTeam = (int)(Math.random()*team.length);
    } while (alreadyUsed.contains(chooseTeam));
    alreadyUsed.add(chooseTeam);

    int chooseResult = (int)(Math.random()*result.length);

    System.out.println("Team is " + team[chooseTeam] + " Result is " 
        + result[chooseResult]);
}