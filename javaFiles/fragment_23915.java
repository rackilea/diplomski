import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask questions about the game type etc.
        System.out.println("Please enter game name: ");
        String gameName = sc.next();
        System.out.println("Please enter " + gameName + " team 1 name: ");
        String t1N = sc.next();
        System.out.println("Please enter " + gameName + " team 2 name: ");
        String t2N = sc.next();
        System.out.println("What is a score in " + gameName + " called? ");
        String scoreName = sc.next();
        System.out.println("How many points per " + scoreName + " in " + gameName + "?");
        int scoreValue = sc.nextInt();
        System.out.println("What is a period in " + gameName + " called?");
        String periodName = sc.next();
        System.out.println("How many " + periodName + " in " + gameName + "?");
        int numberOfPeriods = sc.nextInt();
        int sum1 = 0;
        int sum2 = 0;

        int numberOfScoresT1[] = new int[numberOfPeriods];
        int numberOfScoresT2[] = new int[numberOfPeriods];

        for (int i = 0; i <numberOfPeriods; i++) {
            System.out.println(periodName + " #" + i);

            System.out.println("How many " + scoreName + " for " + t1N + "?");
            numberOfScoresT1[i] = sc.nextInt();

            System.out.println("How many " + scoreName + " for " + t2N + "?");
            numberOfScoresT2[i] = sc.nextInt();

        }
        sc.close();

        for (int counter = 0; counter < numberOfPeriods; counter++) {
            sum1 += numberOfScoresT1[counter];
            sum2 += numberOfScoresT2[counter];
        }

        System.out.println("Team 1 scored " + sum1 + " team 2 scored " + sum2);

    }
}