private static void drawLegs() {
        final char SPACE=' ';
        int DISTANCE = 16;
        final int HEIGHT = 7;
        final char FWD='/';
        final char BWD='\\';
        int starCount = 1;

        for (int row = 0; row < HEIGHT; row++) {
            int spaces = DISTANCE - row;
            for (int count = 0; count < spaces; count++) {
                System.out.print(SPACE);
            }
            System.out.print(FWD);
            for (int i = 0; i < starCount; i++) {
                System.out.print("*");
            }
            System.out.print(FWD);
            for (int i = 0; i < starCount*2; i++) {
                System.out.print(SPACE);
            }
            System.out.print(BWD);
            for (int i = 0; i < starCount; i++) {
                System.out.print("*");
            }
            System.out.print(BWD);
            DISTANCE--;
            starCount++;
            System.out.println();
        }
    }