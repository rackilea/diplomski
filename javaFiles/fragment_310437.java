String[] lines = input.split("\n");
int[][] matrix = new int[lines.length][];

for (int i = 0; i < lines.length; i++) {
    String[] columns = lines[i].split(" ");
    matrix[i] = new int[columns.length];
    for (int j = 0; j < columns.length; j++) {
        matrix[i][j] = Integer.parseInt(columns[j]);
    }
}