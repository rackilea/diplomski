import java.util.Scanner;

public class TeamName {

    public String getTeamName() {
        String team_name = null;

        boolean valid_name = false;
        Scanner reader = new Scanner(System.in);

        while (valid_name == false) {

            System.out.println("Enter team name here: ");
            team_name = reader.nextLine();

            int name_length = team_name.length();

            if (name_length >= 3 && name_length < 10) {
                System.out.println(team_name + "... Sweet as name!");
                valid_name = true;
            }

            else {
                System.out.println("Name must be within 2 - 10 characters! :^)");
                valid_name = false;
            }

        }
        reader.close();
        return team_name;
        }


    public static void main(String[] args) {
        TeamName team = new TeamName();
        team.getTeamName();
    }

}