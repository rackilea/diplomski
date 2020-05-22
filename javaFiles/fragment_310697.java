private ArrayList<Team> teams = new ArrayList<Team>();

while (lineScanner.hasNextLine()){
    currentLine = lineScanner.nextLine();
    String[] newSSs = currentLine.split(","); 
    Team team = new Team(newSS[0]);
    team.setWins(Integer.valueOf(newSS[1]));
    team.setDraws(Integer.valueOf(newSS[2]));
    team.setLoses(Integer.valueOf(newSS[3]));
    team.setPoints(team.calculatePoints());
}