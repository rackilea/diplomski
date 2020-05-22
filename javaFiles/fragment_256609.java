public static void sortSizeable2(List<String> beanz) {
    Collections.sort(beanz);
    final int cols = 3; // Number of columns
    int rows = (int) Math.ceil(beanz.size() / (cols * 1.0));
    String[][] sortedBeanz = new String[rows][cols];
    for (int i = 0; i < beanz.size(); i++) {
        int row = i / rows;
        int col = i % rows;
        sortedBeanz[col][row] = beanz.get(i);
    }
    printOut(sortedBeanz);
}