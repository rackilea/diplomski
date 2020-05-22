public class MainE {

    public static void main(String[] args) {

        String[] homeTeam = { "q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        String[] awayTeam = {"p", "o", "i", "u", "y", "t", "r", "e", "w", "q"};
        int[] homeScore = {5,1,3,5,6,1,10,4,3,2};
        int[] awayScore = {4,3,2,1,3,5,42,1,3,2};

        int sumHome = 0;
        int sumAway = 0;
        int drawCount = 0;

        int highestHomeScore = homeScore[0];
        int highestAwayScore = awayScore[0];

        System.out.println();

        for (int index = 0; index < 10; index++) {

            System.out.println(homeTeam[index] + " [" + homeScore[index] + "]"
                    + " | " + awayTeam[index] + " [" + awayScore[index] + "] ");
            sumHome += homeScore[index];
            sumAway += awayScore[index];

            if (homeScore[index] > highestHomeScore) highestHomeScore = homeScore[index];
            if (awayScore[index] > highestAwayScore) highestAwayScore = awayScore[index];

            if(homeScore[index] == awayScore[index]) drawCount++;
        }



        System.out.println();
        System.out.println("Totals");
        System.out.println("-------------------------------");
        System.out.println("Total number of matches played: " + homeTeam.length);
        System.out.println("Total of all home scores: " + sumHome);
        System.out.println("Total of all away scores: " + sumAway);
        System.out.println("Total number of draws: " + drawCount);
        System.out.println("The highest home score: " + highestHomeScore);
        System.out.println("The highest away score: " + highestAwayScore);

    }

}