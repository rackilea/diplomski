public class MyScoreCalculator {
    static String p1 = "";
    static String p2 = "";
    static int maxScore = 0;
    static int roll1 = 0;
    static int roll2 = 0;
    static int total1 = 0;
    static int total2 = 0;

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // Dialogue to get data...
        // Display scorecard look with players names

        while (total1 < maxScore && total2 < maxScore) { 
            //scorecard quits when maxScore is reached by either player
            roll1 = keyboard.nextInt(); // ask for current roll

            System.out.println(total1 + "+");
            System.out.println(roll1);
            System.out.println("_____");
            System.out.println(roll1 + total1);

            total1 = total1 + roll1;

            // Do the same for next player.
        }
    }
}