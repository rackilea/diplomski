public class BowlingTeam {

String teamName;
String[] members = new String[4];

public String getTeamName() {
    return teamName;
}

public void setTeamName(String team) {
    teamName = team;
}

public void setMember(int number, String name) {
    members[number] = name;
}

public String getMember(int number) {
    return members[number];
}


public static void main(String[] args) {
    String name;
    final int NUM_TEAMS = 4;
    BowlingTeam[] teams = new BowlingTeam[NUM_TEAMS];
    int x;
    int y;
    final int NUM_TEAM_MEMBERS = 4;
    getTeamData(teams);
    for (y = 0; y < NUM_TEAMS; ++y) {
        System.out.println("\nMembers of team " + teams[y].getTeamName());
        for (x = 0; x < NUM_TEAM_MEMBERS; ++x)
            System.out.print(teams[y].getMember(x) + " ");
        System.out.println();
    }
    name = JOptionPane.showInputDialog(null, "Enter a team name to see its roster.");
    for (y = 0; y < teams.length; ++y)
        if (name.equals(teams[y].getTeamName()))
            for (x = 0; x < NUM_TEAM_MEMBERS; ++x)
                System.out.print(teams[y].getMember(x));
    System.out.println();
}

public static void getTeamData(BowlingTeam[] teams) {
    String name;
    final int NUM_TEAMS = 4;
    int x;
    int y;
    final int NUM_TEAM_MEMBERS = 4;
    for (y = 0; y < NUM_TEAMS; ++y) {
        teams[y] = new BowlingTeam();
        name = JOptionPane.showInputDialog(null, "Enter team name");
        teams[y].setTeamName(name);
        for (x = 0; x < NUM_TEAM_MEMBERS; ++x) {
            name = JOptionPane.showInputDialog(null, "Enter team member's name");
            teams[y].setMember(x, name);
        }
    }
}