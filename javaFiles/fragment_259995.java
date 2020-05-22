public static void showResults(String filePath) {
    String separator = "\\s*:\\s*";
    File inputfile = new File(filePath);
    String[] heading = { "Home team", "Home score", "Away team",
            "Away score" };
    for (int i = 0; i < heading.length; i++) {
        String fmt = "%20s ";
        if (i % 2 != 0)
            fmt = "%12s ";
        System.out.printf(fmt, heading[i]);
    }
    System.out.println();
    for (int i = 0; i < 68; i++) {
        System.out.print('=');
    }
    System.out.println();
    int goals = 0;
    try (Scanner filescan = new Scanner(inputfile);) {
        while (filescan.hasNext()) {
            String aLine = filescan.nextLine();
            String[] tokens = aLine.split(separator);
            if (tokens.length == 4) {
                System.out.printf("%20s %12s %20s %12s%n", tokens[0],
                        tokens[2], tokens[1], tokens[3]);
                goals += Integer.parseInt(tokens[2]);
                goals += Integer.parseInt(tokens[3]);
            } else {
                throw new IllegalArgumentException("Invalid match count : "
                        + aLine);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("problem " + e.getMessage());
    }
    System.out.printf("%nTotal goals = %d%n", goals);
}