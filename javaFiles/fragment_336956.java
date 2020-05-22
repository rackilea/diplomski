public class Team {
    int points;
    final String name;

    public Team(String name) { this.name = name; }

    public void setPoints(int p) { this.points = p; }
    public int getPoints() { return this.points; }
    public String getName() { return this.name; }
}

void main() {
    Team arsenal = new Team("Arsenal");
    Team liverpool = new Team("Liverpool");
    ArrayList<Team> teams = new ArrayList<Team>();
    teams.add(arsenal);
    teams.add(liverpool);

    Scanner in = new Scanner(System.in);
    for(Team team : teams) {
        System.out.println("How many points did " + team.getName() + " made today");
        Integer points = in.nextInt();
        team.setScore(points);
    }

    // Sort the teams by score somehow
    teams.sort()

    // Get the winners 
    ArrayList<List> winners = this.getWinners(teams)

    if (winners.count > 1) {
        // It's a draw between the ones in the winners arraylist
    } else {
        println("The winner is: " + winners.get(0).name)
    }
}