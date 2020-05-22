static String[] linesT = { "-----",
                           "  |  ",
                           "  |  ",
                           "  |  ",
                           "  |  " };

static String[] linesI = { "-----",
                           "  |  ",
                           "  |  ",
                           "  |  ",
                           "-----" };

static String[] linesL = { "|    ",
                           "|    ",
                           "|    ",
                           "|    ",
                           "-----" };

private static void printOut(String letters) {
    for (int line = 0; line < 5; line++) {
        for (int letter = 0; letter < letters.length(); letter++) {
            switch (letters.charAt(letter)) {
                case 'T':
                    System.out.print(linesT[line]);
                    break;
                case 'I':
                    System.out.print(linesI[line]);
                    break;
                case 'L':
                    System.out.print(linesL[line]);
                    break;

                default:
                    throw new IllegalArgumentException("Cannot print letter " + letters.charAt(letter));
            }
            System.out.print(' ');
        }
        System.out.println();
    }
}