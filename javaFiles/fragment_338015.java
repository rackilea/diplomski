public class Scores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int scores[];
        System.out
                .println("**************************************************");
        System.out.println("First player");
        Person player1 = new Person();
        System.out.println("Enter name");
        player1.setName(scanner.nextLine());
        System.out.println("Enter the number of games played");
        player1.setGames(scanner.nextInt());
        scores = new int[player1.getGames()];
        for (int i = 0; i < player1.getGames(); i++) {
            System.out.println("Enter the score for each game");
            scores[i] = scanner.nextInt();
        }
        player1.setScores(scores);

        System.out
                .println("**************************************************");
        scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Second player");
        Person player2 = new Person();
        System.out.println("Enter name");
        player2.setName(scanner.nextLine());
        System.out.println("Enter the number of games played");
        player2.setGames(scanner.nextInt());
        scores = new int[player2.getGames()];
        for (int i = 0; i < player2.getGames(); i++) {
            System.out.println("Enter the score for each game");
            scores[i] = scanner.nextInt();
        }
        player2.setScores(scores);

        // compare the scores and output the result

        compareScores(player1, player2);

    }

    private static void compareScores(Person player1, Person player2) {
        // assuming both of them played the same number of games.
        if (player1.getGames() == player2.getGames()) {
            int player1Scores[] = player1.getScores();
            int player2Scores[] = player2.getScores();
            for (int i = 0; i < player1.getGames(); i++) {
                System.out.println("Game " + (i + 1) + " Results");
                if (player1Scores[i] > player2Scores[i]) {
                    System.out.println(player1.getName()+" won ");
                } else if (player1Scores[i] < player2Scores[i]) {
                    System.out.println(player2.getName()+" won ");
                } else {
                    System.out.println("Scores are level");
                }
            }
        }
    }
}