private static void printStars(int rows, int columns)
{

    int stars = 1;

    while (rows > 0) {

        int spaces = rows;

        for (int i = 1; i <= columns; i++) {

            for (int sp = spaces; sp >= 1; sp--) {
                System.out.print(" ");
            }
            for (int st = stars; st >= 1; st--) {
                System.out.print("*");
            }
            for (int sp = spaces; sp >= 1; sp--) {
                System.out.print(" ");
            }
        }
        System.out.println();
        stars += 2;
        rows--;
    }
}