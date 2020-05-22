public static void main(String[] args) {

    String hwnames[] = {"hw 1", "hw 2", "hw 3", "hw 4", "hw 5", "test 1", "test 2", "test 3"};
    int hwnvalues[] = {20, 20, 20, 20, 20, 30, 30, 30};

    int[][] x = {{20, 20, 20, 20, 20, 30, 30, 30},
            {20, 20, 20, 20, 20, 30, 30, 30},
            {20, 20, 20, 20, 20, 30, 30, 30},
            {20, 20, 20, 20, 20, 30, 30, 30},
            {20, 20, 20, 20, 20, 30, 30, 30}};
    String testNames[] = {"really", "am", "sick", "of", "this"};
    String percentages[] = {"82.5", "90", "92", "88", "95"};

    drawHeader(hwnames);
    System.out.println();
    drawHeaderValue(hwnvalues);
    System.out.println();
    for (int i = 0; i<testNames.length; i++)
        drawValues(testNames[i], x[i], percentages[i]);
}

public static void drawValues(String header, int[] values, String percentage) {
    System.out.format("%6s |", header);
    for (int i = 0; i<values.length; i++) {
        System.out.format("%7.1f |", (double)values[i]);
    }
    System.out.format("%7.2f", Double.valueOf(percentage));
    System.out.println("%");
}

public static void drawHeader(String[] hwnames) {
    System.out.format("%6s |", " ");
    for(int i = 0; i < hwnames.length; i++)
        System.out.format("%7s |", hwnames[i]);
}
public static void drawHeaderValue(int[] hwvalues) {
    System.out.format("%6s |", " ");
    for(int i = 0; i < hwvalues.length; i++)
        System.out.format("%7d |", hwvalues[i]);
}