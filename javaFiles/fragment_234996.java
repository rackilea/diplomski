ArrayList<String> team = new ArrayList<String>();
team.add("Astonvilla");
team.add("Realmadrid");
team.add("Ajax");
team.add("Barcelona");
team.add("Manunited");
String [] result={"0","1","2"}; 
for(int i = 0; i < 3; i++) {
    int chooseTeam = (int)(Math.random()*team.size());
    int chooseResult = (int)(Math.random()*result.length);

    System.out.println("Team is " + team.get(chooseTeam) + " Result is " 
        + result[chooseResult]);
    team.remove(chooseTeam);
}