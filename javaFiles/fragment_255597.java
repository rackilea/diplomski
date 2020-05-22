import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fantasyFootball {

    private List<String> teamNames = new ArrayList<String>();
    private int numberOfTeams; // Same as teamAverage.length.
    private int numberOfWeeks; // Same as weekAverage.length.

    private int[][] score; // numberOfTeams rows and numberOfWeeks columns.
    private int[] teamAverage;
    private int[] scoreAverage;

    public static void main(String[] args) {
        fantasyFootball book = new fantasyFootball();
        book.display();
    }

    public fantasyFootball(int[][] a) {
        if (a.length == 0 || a[0].length == 0) {
            System.out.println("Empty score records. Aborting.");
            System.exit(0);
        }

        numberOfTeams = a.length;
        numberOfWeeks = a[0].length;
        fillScore(a);
        fillTeamAverage();
        fillScoreAverage();
    }

    public fantasyFootball(fantasyFootball book) {
        numberOfTeams = book.numberOfTeams;
        numberOfWeeks = book.numberOfWeeks;
        fillScore(book.score);
        fillTeamAverage();
        fillScoreAverage();
    }

    public fantasyFootball() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter number of teams:");
        numberOfTeams = keyboard.nextInt();

        System.out.println("Enter number of weeks:");
        numberOfWeeks = keyboard.nextInt();

        score = new int[numberOfTeams][numberOfWeeks];

        for (int teamName = 1; teamName <= numberOfTeams; teamName++){
            System.out.println("Enter team " + teamName + " name ");
            String name = keyboard.next();
            teamNames.add(name);
            for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++) {
                System.out.println("Enter score for team " + teamName + " on week number " + weekNumber);
                score[teamName - 1][weekNumber - 1] = keyboard.nextInt();
            }
        }

        fillTeamAverage();
        fillScoreAverage();
    }

    private void fillScore(int[][] a) {
        score = new int[numberOfTeams][numberOfWeeks];

        for (int teamName = 1; teamName <= numberOfTeams; teamName++) {
            for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++)
                score[teamName][weekNumber] = a[teamName][weekNumber];
        }
    }

    /**
     * Fills the array teamAverage using the data from the array score.
     */
    private void fillTeamAverage() {
        teamAverage = new int[numberOfTeams];

        for (int teamName = 1; teamName <= numberOfTeams; teamName++) {// Process
                                                                        // one
                                                                        // teamName:
            int sum = 0;
            for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++)
                sum = sum + score[teamName - 1][weekNumber - 1];
            // sum contains the sum of the week scores for team number teamName.
            teamAverage[teamName - 1] = sum / numberOfWeeks;
            // Average for team teamNumber is teamAverage[teamNumber - 1]
        }
    }

    /**
     * Fills the array scoreAverage using the data from the array score.
     */
    private void fillScoreAverage() {
        scoreAverage = new int[numberOfWeeks];

        for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++) {// Process
                                                                                // one
                                                                                // week
                                                                                // (for
                                                                                // all
                                                                                // teams):
            int sum = 0;
            for (int teamName = 1; teamName <= numberOfTeams; teamName++)
                sum = sum + score[teamName - 1][weekNumber - 1];
            // sum contains the sum of all team scores on week number
            // weekNumber.
            scoreAverage[weekNumber - 1] = sum / numberOfTeams;
            // Average for week weekNumber is the value of
            // weekAverage[weekNumber - 1]
        }
    }

    public void display() {
        for (int teamName = 1; teamName <= numberOfTeams; teamName++)

        {// Display for one teamNumber:
            System.out.print("Team " + teamNames.get(teamName-1) + " Weeks: ");
            for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++)
                System.out.print(score[teamName - 1][weekNumber - 1] + " ");
            System.out.println(" Ave = " + teamAverage[teamName - 1]);
        }

        System.out.println("Week averages: ");
        for (int weekNumber = 1; weekNumber <= numberOfWeeks; weekNumber++)
            System.out.print("Week " + weekNumber + " Ave = "
                    + scoreAverage[weekNumber - 1] + " ");
        System.out.println();
    }

    private void teamName() {
        Scanner keyboard = new Scanner(System.in);
        String[] teamName = new String[3];

    }
}