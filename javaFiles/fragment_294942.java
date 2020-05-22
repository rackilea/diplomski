public class DiceGame {

    public static int attempt = 1;

    public static void main(String[] args) {

        int dice1 = 0;
        int dice2 = 0;
        int sum = 0;

        while (true) {
            System.out.println();
            System.out.println("Rolling dice for " + attempt + " time!");

            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            sum = dice1 + dice2;

            System.out.println("Roll: total = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Sorry with a " + sum + " you loose :(!");
                System.out.println();
                break;
            } else if (sum == 7 || sum == 11) {
                System.out.println("With a " + sum + " you win :)!");
                System.out.println();
                break;
                // this will roll the dices automatically
                // when sum is 4, 5, 6, 8, 9 or 10
            } else {
                System.out.println();
                System.out.println("With " + sum + " dices are rolled again automatically!!");
                attempt++;
            }
        }
        System.out.println("Thanks for playing dice game, you rolled the dice " + attempt + " times!");
    }
}