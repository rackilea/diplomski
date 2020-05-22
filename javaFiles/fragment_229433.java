public static void main(String[] args) {
    score();
    System.out.println("Your score is " + scr);
    System.exit(0);
}

static int scr = 0;

public static int score() {
    if (questionOneAnswer()) scr++;
}