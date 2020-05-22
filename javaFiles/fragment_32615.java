public class Graph {
    public ArrayList nodes = new ArrayList();
    public int[][] adjacentMatrix;
    int size;

    public void addNode(Node n) {
    nodes.add(n);
    }

    public void addEdge(Node start, Node end, int weight) {
    if (adjacentMatrix == null) {
        size = nodes.size();
        adjacentMatrix = new int[size][size];
    }
    int startIndex = nodes.indexOf(start);
    int endIndex = nodes.indexOf(end);
    adjacentMatrix[startIndex][endIndex] = weight;
    }

    public static void printAdjacentMatrix(int matrix[][]) {
    for (int row = 0; row < matrix.length; row++) {
        for (int column = 0; column < matrix[row].length; column++) {
        System.out.print(matrix[row][column] + " ");
        }
        System.out.println();
    }
    }

    public static void convertMatrix(int matrix[][]) {
    int row = matrix.length + 2;
    int column = matrix[0].length + 1;
    String newMatrix[][] = new String[row][column];
    initializeFirstRow(newMatrix);
    initializeFirstColumn(newMatrix);
    copyMatrix(matrix, newMatrix);
    addMean(matrix, newMatrix);
    printAdjacentMatrix(newMatrix);
    }

    private static void initializeFirstColumn(String[][] newMatrix) {
    newMatrix[1][0] = "A";
    newMatrix[2][0] = "B";
    newMatrix[3][0] = "C";
    newMatrix[4][0] = "D";
    newMatrix[5][0] = "X";
    }

    private static void printAdjacentMatrix(String[][] newMatrix) {
    for (int row = 0; row < newMatrix.length; row++) {
        for (int column = 0; column < newMatrix[row].length; column++) {
        System.out.print(newMatrix[row][column] + " ");
        }
        System.out.println();
    }
    }

    private static void addMean(int[][] matrix, String[][] newMatrix) {
    int mean = 0;
    int sum = 0;
    int divident = 0;
    for (int j = 0; j < matrix[0].length; j++) {
        sum = 0;
        divident = 0;
        for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][j] != 0) {
            sum += matrix[i][j];
            divident++;
        }
        }
        if (sum != 0) {
        mean = sum / divident;
        }
        newMatrix[5][j + 1] = "" + mean;
    }
    }

    private static void copyMatrix(int[][] matrix, String[][] newMatrix) {
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
        newMatrix[i + 1][j + 1] = "" + matrix[i][j];
        }
    }
    }

    private static void initializeFirstRow(String[][] newMatrix) {
    newMatrix[0][0] = " ";
    newMatrix[0][1] = "A";
    newMatrix[0][2] = "B";
    newMatrix[0][3] = "C";
    newMatrix[0][4] = "D";
    }
}