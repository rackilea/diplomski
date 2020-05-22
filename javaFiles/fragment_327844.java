public static void main(String[] args) {
    System.out.println("Welcome to Price is Right!");
    int[] scores = new int[3];
    int maxScore = -1;
    int maxUser = 0;
    for (int i = 0; i < scores.length; i++) {
        System.out.println("Player " + (i+1) + " are you ready to spin?");
        scores[i] = player();
        if (scores[i] > maxScore) {
            maxUser = i;
            maxScore = scores[i];
        }
        System.out.println("Player " + (i+1) + " Your final score is: " + scores[i]);
    }
    System.out.println("Player " + (maxUser+1) + " won with a final score of " + maxScore);
}