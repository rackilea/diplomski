import java.util.Random;

    public class Maze {
    private final int[][] grid;
    private final int width, height;

    public static void main(String args[]) {
        Maze mz = new Maze(20, 20);
        mz.moveMouse();
    }

    private void generateDefaultMaze() {
        System.out.println(this);
        // * empty = 0, wall = 1, border = 2, travelled =3;

        // mark borders
        for (int curr = 0; curr < height; curr++) {
            grid[0][curr] = 2; // top
            grid[curr][0] = 2; // left
            grid[height - 1][curr] = 2; // bottom
            grid[curr][width - 1] = 2; // right
        }
        // initially mark all cells as walls
        for (int row = 1; row < height - 1; row++) {
            for (int col = 1; col < width - 1; col++) {
                grid[row][col] = 1;
            }
        }

        System.out.println(this);
    }

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[width][height];
        this.generateDefaultMaze();
    }

    /**
     * Overridden method to generate a human readable maze state.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(1024);
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                sb.append(this.grid[i][j]).append(",");
            }
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("**************");
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Row pointer can either move left or right and it's value should be
     * between 0 and width. In case of 0 value at this grid[row][col] do not
     * move the pointer.
     * 
     * @param row The row pointer value.
     * @param col The column pointer value.
     * @return
     */
    private boolean isValidTurn(int row, int col) {
        if (row >= 0 && row < width && !(this.grid[col][row] == 0)) {
            return true;
        }
        return false;
    }

    public void moveMouse() {
        Random r = new Random();
        int row = r.nextInt(width);
        int col = 0;

        grid[col][row] = 0;
        // System.out.println(this);
        while (col < (this.height - 1)) {
            // Assuming the mouse moves in only 3 directions left right or down
            // in the maze. 0 indicates left turn 1 indicates right turn and
            // 2 indicates down movement in the maze.
            int nextDir = r.nextInt(3);
            switch (nextDir) {
            case 0: // left turn
                if (this.isValidTurn((row - 1), col)) {
                    --row;
                    this.grid[col][row] = 0;
                }
                break;
            case 1: // right turn
                if (this.isValidTurn((row + 1), col)) {
                    ++row;
                    this.grid[col][row] = 0;
                }
                break;
            case 2: // down movement
                ++col;
                this.grid[col][row] = 0;
                break;
            }
            System.out.println("turn : " + nextDir);
            // System.out.println(this);
        }
        System.out.println(this);
    }
 }