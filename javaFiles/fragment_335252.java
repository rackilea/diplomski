private static void printTimeTable() throws FileNotFoundException {
    try {
        File file = new File("Lab Print Time Table");

        PrintWriter printWriter = new PrintWriter("TimeTables.txt");

        printWriter.println("\tTimes Tables:\n");
        for (int i = 1; i <= 10; i += 2) {
            for (int j = 1; j <= 10; j++) {

                System.out.printf("%-2d * %-2d = %-2d", j, i, i * j);
                System.out
                        .printf("%10d * %d = %d\n", j, i + 1, j * (i + 1));

                printWriter.printf("%-2d * %-2d = %-2d", j, i, i * j);
                printWriter.printf("%10d * %d = %d\n", j, i + 1, j
                        * (i + 1));

            }
            System.out.println("");

            printWriter.println("");
        }
        printWriter.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }}