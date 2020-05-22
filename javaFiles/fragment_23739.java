public static void main(String[] args) {

    // first an example matrix with chars to fit your example
    char[][] matrix = new char[3][];
    matrix[0] = new char[]{'A', 'B', '0', '1'};
    matrix[1] = new char[]{'C', 'D', '2', '3'};
    matrix[2] = new char[]{'4', '5', '6', '7'};

    // then the elements you want to move (the highest index first!)
    Point[] elements = new Point[]{
        new Point(1, 1),
        new Point(1, 0),
        new Point(0, 1),
        new Point(0, 0)
    };

    // the direction indicates with where the element has to go to from it's current index. So (1,1) means one right, one down
    Point directionPoint = new Point(1, 1);
    // print the matrix to see what the original looks like
    printMatrix(matrix);

    // iterate through the elements that have to be moved
    for (Point p : elements) {
        move(p, directionPoint, matrix);
        printMatrix(matrix); 
    }
}

// this method takes one element, the direction and the matrix and moves this one element by switching it with the element that is at its destination index
public static void move(Point elementToMove, Point direction, char[][] matrix) {
    char temp = matrix[elementToMove.x][elementToMove.y];
    matrix[elementToMove.x][elementToMove.y] = matrix[elementToMove.x + direction.x][elementToMove.y + direction.y];
    matrix[elementToMove.x + direction.x][elementToMove.y + direction.y] = temp;
}

// just a simple print method to see the current matrix
public static void printMatrix(char[][] matrix) {
    for (char[] row : matrix) {
        String line = "";
        for (int i = 0; i < row.length; i++) {
            line += row[i] + " ";
        }
        System.out.println(line);
    }
    System.out.println("---");
}