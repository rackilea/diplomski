import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//a stack representing cells in the path
//each cell represented by [row,col]
class Path extends Stack<int[]>{

    private Token[][] grid;

    //a path shorter than min can not surround any cell
    private static final int MIN_PATH_LEGTH = 3;

    //a collection of cells that has been tested
    private ArrayList<int[]>checked;

    //represents the cell where the search starts from
    int[] origin;
    //represents the token of the origin
    Token originToken;

    private int rows;
    private int cols;

    //represents the path bounds: min/max row/col in path
    private int minPathRow, maxPathRow, minPathCol, maxPathCol;

    //a collection of all cells that are bounded by the path
    //and their token is of the opposite color of the path
    private List<int[]> containedWithin;

    //a STATIC collection that holds all containedWithin cells, of
    //current and previous paths
    private static CellsList allContainedWithin = new CellsList();

    Path(Token[][] grid){

        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
    }

    //search for a path
    boolean findPath(int[] origin) {

        this.origin = origin;

        int row = origin[0] , col =  origin[1];

        //represents the token of the origin
        originToken = grid[row][col];

        //initialize list of checked items
        checked = new  CellsList();

        boolean found = findPath(row, col);

        if(found) {

            //find bounded cells
            findContainedWithin();
            //update the collection all
            allContainedWithin.addAll(containedWithin);

            printPath();
        } else {
            System.out.println("No path found");
        }

        return found;
    }

    //recursive method to find path. a cell is represented by its row, col
    //returns true when path was found
    private boolean findPath(int row, int col) {

        //check if cell has the same token as origin
        if(grid[row][col] != originToken) {
            return false;
        }

        int[] cell = new int[] {row, col};

        //check if this cell was tested before to avoid checking again
        if(checked.contains(cell)) {
            return false;
        }

        //check if this cell was contained in previously calculated paths
        if(allContainedWithin.contains(cell)) {
            return false;
        }

        //get cells neighbors
        CellsList neighbors = getNeighbors(row, col);

        //check if solution found. If path size > min and cell
        //neighbors contain the origin it means that path was found
        if((size() >= MIN_PATH_LEGTH) && neighbors.contains(origin)  ) {

            add(cell);
            return true;
        }

        //add cell to checked
        checked.add(cell);

        //add cell to path
        add(cell);

        //if path was not found check cell neighbors
        for(int[] neighbor : neighbors ) {

            boolean found = findPath(neighbor[0],neighbor[1]);
            if(found) {
                return true;
            }
        }

        //path not found
        pop(); //remove last element from stack
        return false;
    }

    //return a list of all neighbors of cell row, col
    private CellsList getNeighbors(int  row, int col) {

        CellsList neighbors = new CellsList();

        for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {

            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {

                if(!((colNum == col) && (rowNum == row))) {

                    if(isWithinGrid (rowNum, colNum )  ) {

                        neighbors.add( new int[] {rowNum, colNum});
                    }
                }
            }
        }

        return neighbors;
    }

    private boolean isWithinGrid(int colNum, int rowNum) {

        if((colNum < 0) || (rowNum <0) ) {
            return false;
        }
        if((colNum >= cols) || (rowNum >= rows)) {
            return false;
        }
        return true;
    }

    //use for testing
    private void printPath() {

        System.out.print("Path : " );
        for(int[] cell : this) {
            System.out.print(Arrays.toString(cell));
        }
        System.out.println("");

        List<int[]> containedCells = getContainedWithin();

        System.out.print(containedCells.size()+" cell contained : " );
        for(int[] cell : containedCells) {
            System.out.print(Arrays.toString(cell));
        }
        System.out.println("");
    }

    CellsList getPath() {

        CellsList cl = new CellsList();
        cl.addAll(this);
        return cl;
    }

    //finds all cells that are bounded by the path
    //and their token is of the opposite color of the path
    private void findContainedWithin() {

        containedWithin = new ArrayList<>();

        //find path max and min X values, max and min Y values
        minPathRow = grid[0].length; //set min to the largest possible value
        maxPathCol = grid.length;
        maxPathRow = 0;              //set max to the largest possible value
        maxPathCol = 0;

        //find the actual min max x y values of the path
        for (int[] cell : this) {
            minPathRow = Math.min(minPathRow, cell[0]);
            minPathCol = Math.min(minPathCol, cell[1]);
            maxPathRow = Math.max(maxPathRow, cell[0]);
            maxPathCol = Math.max(maxPathCol, cell[1]);
        }

        //todo remove after testing
        System.out.println("x range: "+minPathRow + "-"
        + maxPathRow + " y range: " + minPathCol + "-" + maxPathCol);

        int[] cell = get(0);//get an arbitrary cell in the path
        Token pathToken = grid[cell[0]][cell[1]]; //keep a reference to its token

        //iterate over all cells within path x, y limits
        for (int col = minPathCol; col < (maxPathCol); col++) {

            for (int row = minPathRow; row < (maxPathRow); row++) {

                //check cell color
                Token token = grid[row][col];
                if ((token == pathToken) || (token == Token.VIDE)) {
                    continue;
                }
                if (isWithinLoop(row,col)) {
                    containedWithin.add(new int[] {row, col});
                }
            }
        }
    }

    //returns a collection of all cells that are bounded by the path
    //and their token is of the opposite color of the path
    List<int[]> getContainedWithin() {

        return containedWithin;
    }

    //check if row, col represent a cell with in path by checking if it has a
    //path-cell to its left, right, top and bottom
    private boolean isWithinLoop(int row, int col) {

        if(  isPathCellOnLeft(row, col)
             &&
             isPathCellOnRight(row, col)
             &&
             isPathCellOnTop(row, col)
             &&
             isPathCellOnBottom(row, col)
          ) {
            return true;
        }

        return false;
    }

    private boolean isPathCellOnLeft(int cellRow, int cellCol) {

        for ( int col = minPathCol; col < cellCol ; col++) {

            if(getPath().contains(new int[] {cellRow, col})) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathCellOnRight(int cellRow, int cellCol) {

        for ( int col = cellCol; col <= maxPathCol ; col++) {

            if(getPath().contains(new int[] {cellRow, col})) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathCellOnTop(int cellRow, int cellCol) {

        for ( int row =minPathRow; row < cellRow ; row++) {

            if(getPath().contains(new int[] {row, cellCol})) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathCellOnBottom(int cellRow, int cellCol) {

        for ( int row = cellRow; row <= maxPathRow; row++) {

            if(getPath().contains(new int[] {row, cellCol})) {
                return true;
            }
        }

        return false;
    }
}