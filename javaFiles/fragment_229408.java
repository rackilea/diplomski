public class Face{
    private int[][] grid;

    public Face(int[][] grid){
        this.grid = grid;
    }

    enum DIRECTION {
        RIGHT,
        LEFT
    }

    public Face rotateFront(DIRECTION direction){
        int rows = grid.length;
        int[][] transposedArray = new int[rows][rows];

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<rows; j++){
                if (direction == DIRECTION.RIGHT) {
                    transposedArray[j][(rows-1)-i]=grid[i][j];
                } else {
                    transposedArray[(rows-1)-j][i]=grid[i][j];
                }
            }
        }

        return new Face(transposedArray);
    }

    public String toString() {
        int rows = grid.length;
        String output = "";
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<rows; j++){
                output += "["+ grid[i][j]+"] ";
            }
            output += "\n";
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] originalArray = new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};

        System.out.println("Create our inital Face:");
        Face startFace = new Face(originalArray);
        System.out.println(startFace);

        System.out.println("Rotate our inital Face to the right:");
        Face rotatedFace = startFace.rotateFront(DIRECTION.RIGHT);
        System.out.println(rotatedFace);

        System.out.println("Rotate our rotated Face to the left:");
        Face rotatedFace2 = rotatedFace.rotateFront(DIRECTION.LEFT);
        System.out.println(rotatedFace2);
    }
}