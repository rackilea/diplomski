public static void main(String[] args) {
    String input = "1111111111111111111111111111111111111111111\n" +
                   "1000000010001000001000000010000000100000001\n" +
                   "1010111010101010101111101011111010111111101\n" +
                   "1010001010100010100000001010000010000010001\n" +
                   "1011101010111110101111111010111111111010111\n";
    String[][] matrix = load(input);
    print(matrix);
}
private static String[][] load(String input) {
    List<String[]> rows = new ArrayList<>();
    try (Scanner sc = new Scanner(input)) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] cols = new String[line.length()];
            for (int i = 0; i < cols.length; i++) {
                cols[i] = line.substring(i, i + 1);
            }
            rows.add(cols);
        }
    }
    return rows.toArray(new String[rows.size()][]);
}
private static void print(String[][] matrix) {
    System.out.println("Columns " + matrix[0].length);
    System.out.println("Lines " + matrix.length);
    for (String[] row : matrix) {
        for (String col : row) {
            System.out.print(col + " ");
        }
        System.out.println();
    }
}